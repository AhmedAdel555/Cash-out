package com.ahlymomkn.cashout.controller;

import com.ahlymomkn.cashout.model.entity.User;
import com.ahlymomkn.cashout.payload.AuthorizeAmountDTO;
import com.ahlymomkn.cashout.service.BalanceService;
import com.ahlymomkn.cashout.service.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;


@RestController
@RequestMapping("/balance")
public class BalanceController {
    private  final BalanceService balanceService;
    private final UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(BalanceController.class);

    @Autowired
    public BalanceController(BalanceService balanceService, UserService userService) {
        this.balanceService = balanceService;
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Integer> findUserBalance(@PathVariable("userId") Integer userId) {
        logger.info("Fetching user for userId: {}", userId);

        User user = userService.findUserById(userId);
        logger.info("Found user: {}", user);

        ResponseEntity<Integer> balanceResponse = balanceService.findUserBalance(user);
        Integer balance = balanceResponse.getBody();

        logger.info("Received balance: {}", balance);

        return ResponseEntity.ok(balance);
    }

    @PostMapping("/authorize-amount")
    public ResponseEntity<String> authorizeAmount(@Valid @RequestBody AuthorizeAmountDTO authorizeAmount) throws BadRequestException {
        User user = userService.findUserById(authorizeAmount.getUserId());
        String otpCode = this.balanceService.authorizeAmount(user, authorizeAmount.getAmount());
        return ResponseEntity.ok(otpCode);
    }

    @PostMapping("/cashout")
    public ResponseEntity<String> confirmCashout(@RequestParam String otpCode) throws BadRequestException {
        String message = this.balanceService.cashoutAmount(otpCode);
        return ResponseEntity.ok(message);
    }
}
