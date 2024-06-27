package com.ahlymomkn.cashout.util.OTPStatus;

import com.ahlymomkn.cashout.exception.InvalidOrderStateException;
import com.ahlymomkn.cashout.model.entity.OTP;

public class ExpiredOTPState implements OTPState{

    private OTP otp;

    public ExpiredOTPState(OTP otp){
        this.otp = otp;
    }

    @Override
    public void paid() {
        throw new InvalidOrderStateException("can not to convert from expired state to paid state");
    }

    @Override
    public void expired() {
        throw new InvalidOrderStateException("can not to convert from expired state to expired state");
    }
}
