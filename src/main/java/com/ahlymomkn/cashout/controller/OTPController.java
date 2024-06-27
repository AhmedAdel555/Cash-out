package com.ahlymomkn.cashout.controller;

import com.ahlymomkn.cashout.model.entity.OTP;
import com.ahlymomkn.cashout.payload.OTPDetailsDTO;
import com.ahlymomkn.cashout.payload.UserDTO;
import com.ahlymomkn.cashout.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otp")
public class OTPController {
    private final OTPService otpService;

    @Autowired
    public OTPController(OTPService otpService) {
        this.otpService = otpService;
    }

    @GetMapping("/{code}")
    public ResponseEntity<OTPDetailsDTO> findOtpByCode(@RequestParam("code") String code){
        OTP otp = this.otpService.findOTPByCode(code);
        OTPDetailsDTO otpDetailsDTO = new OTPDetailsDTO(otp.getId(), otp.getAmount(), otp.getExpirationDate(), otp.getCode());
        UserDTO userDTO = new UserDTO(otp.getUser().getId(), otp.getUser().getNationalId(), otp.getUser().getUsername(), otp.getUser().getMobileNumber(), otp.getUser().getImageUrl());
        otpDetailsDTO.setUserDTO(userDTO);
        return ResponseEntity.ok(otpDetailsDTO);
    }

}
