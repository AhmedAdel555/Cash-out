package com.ahlymomkn.cashout.util.OTPStatus;

import com.ahlymomkn.cashout.model.entity.OTP;
import com.ahlymomkn.cashout.model.enums.OTPStatus;

public class NewOTPState implements OTPState{

    private OTP otp;

    public NewOTPState(OTP otp) {
        this.otp = otp;
    }

    @Override
    public void paid() {
        otp.setState(OTPStatus.PAID);
        otp.setStateBehavior(new PaidOTPState(otp));
    }

    @Override
    public void expired() {
        otp.setState(OTPStatus.EXPIRED);
        otp.setStateBehavior(new ExpiredOTPState(otp));
    }
}
