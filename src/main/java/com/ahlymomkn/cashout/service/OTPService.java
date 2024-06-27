package com.ahlymomkn.cashout.service;

import com.ahlymomkn.cashout.model.entity.OTP;

public interface OTPService {

    public OTP findOTPByCode(String otpCode);

    public void findExpiredCodes() throws Exception;
}
