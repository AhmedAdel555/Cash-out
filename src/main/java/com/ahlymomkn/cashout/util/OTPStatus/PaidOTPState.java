package com.ahlymomkn.cashout.util.OTPStatus;

import com.ahlymomkn.cashout.exception.InvalidOrderStateException;
import com.ahlymomkn.cashout.model.entity.OTP;
import org.apache.coyote.BadRequestException;

public class PaidOTPState implements OTPState{

    private OTP otp;

    public PaidOTPState(OTP otp){
        this.otp = otp;
    }

    @Override
    public void paid() {
       throw new InvalidOrderStateException("can not to convert from paid state to paid state");
    }

    @Override
    public void expired() {
        throw new InvalidOrderStateException("can not to convert from paid state to expired state");
    }
}
