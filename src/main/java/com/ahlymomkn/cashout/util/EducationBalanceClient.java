package com.ahlymomkn.cashout.util;

import com.ahlymomkn.cashout.payload.TransactionAmountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@FeignClient(name = "education-balance", url = "http://balanceportal.runasp.net")
public interface EducationBalanceClient {

    @GetMapping("/api/ProfessorTransaction/transactions/{nationalId}/last-balance")
    public ResponseEntity<Integer> findUserBalance(@PathVariable("nationalId") String nationalId);

    @PostMapping("/authorize-amount")
    public ResponseEntity<String> authorizeAmount(@RequestBody TransactionAmountDTO transactionAmountDTO);

    @PostMapping("/api/ProfessorTransaction/transactions")
    public ResponseEntity<String> cashoutAmount(@RequestBody TransactionAmountDTO transactionAmountDTO);

    @PostMapping("/reverse-amounts")
    public ResponseEntity<String> reverseAmounts(@RequestBody List<TransactionAmountDTO> transactionAmountDTOS);
}
