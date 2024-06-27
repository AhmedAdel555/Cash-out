package com.ahlymomkn.cashout.controller;

import com.ahlymomkn.cashout.model.entity.User;
import com.ahlymomkn.cashout.payload.AuthorizeAmountDTO;
import com.ahlymomkn.cashout.service.BalanceService;
import com.ahlymomkn.cashout.service.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/balance")
public class BalanceController {
    private  final BalanceService balanceService;
    private final UserService userService;
    
    @Autowired
    public BalanceController(BalanceService balanceService, UserService userService) {
        this.balanceService = balanceService;
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<BigDecimal> findUserBalance(@PathVariable("userId") Integer userId) {
        User user = userService.findUserById(userId);
        BigDecimal balance = balanceService.findUserBalance(user);
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
