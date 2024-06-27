package com.ahlymomkn.cashout.util;

import com.ahlymomkn.cashout.payload.TransactionAmountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@FeignClient(name = "education-balance", url = "http://localhost:8080")
public interface EducationBalanceClient {

    @GetMapping("/balance")
    public ResponseEntity<BigDecimal> findUserBalance(@RequestParam("nationalId") String nationalId);

    @PostMapping("/authorize-amount")
    public ResponseEntity<String> authorizeAmount(@RequestBody TransactionAmountDTO transactionAmountDTO);

    @PostMapping("/cashout")
    public ResponseEntity<String> cashoutAmount(@RequestBody TransactionAmountDTO transactionAmountDTO);

    @PostMapping("/reverse-amounts")
    public ResponseEntity<String> reverseAmounts(@RequestBody List<TransactionAmountDTO> transactionAmountDTOS);
}
