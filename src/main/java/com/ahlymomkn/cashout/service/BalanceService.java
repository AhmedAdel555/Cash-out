package com.ahlymomkn.cashout.service;

import com.ahlymomkn.cashout.model.entity.User;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public interface BalanceService {
    public ResponseEntity<Integer> findUserBalance(User user);

    public String authorizeAmount(User user , BigDecimal amount) throws BadRequestException;

    public String cashoutAmount(String otpCode) throws BadRequestException;

}
