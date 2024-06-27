package com.ahlymomkn.cashout.service;

import com.ahlymomkn.cashout.model.entity.OTP;
import com.ahlymomkn.cashout.model.entity.User;
import com.ahlymomkn.cashout.payload.AuthorizeAmountDTO;
import org.apache.coyote.BadRequestException;

import java.math.BigDecimal;

public interface BalanceService {
    public BigDecimal findUserBalance(User user);

    public String authorizeAmount(User user , BigDecimal amount) throws BadRequestException;

    public String cashoutAmount(String otpCode) throws BadRequestException;

}
