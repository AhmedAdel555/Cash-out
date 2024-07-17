package com.ahlymomkn.cashout.service.impl;

import com.ahlymomkn.cashout.model.entity.OTP;
import com.ahlymomkn.cashout.payload.TransactionAmountDTO;
import com.ahlymomkn.cashout.repository.OTPRepository;
import com.ahlymomkn.cashout.service.OTPService;
import com.ahlymomkn.cashout.util.EducationBalanceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OTPServiceImpl implements OTPService {

    private final OTPRepository otpRepository;
    private final EducationBalanceClient educationBalanceClient;

    @Autowired
    public OTPServiceImpl(OTPRepository otpRepository, EducationBalanceClient educationBalanceClient) {
        this.otpRepository = otpRepository;
        this.educationBalanceClient = educationBalanceClient;
    }

    @Override
    public OTP findOTPByCode(String otpCode) {
        return otpRepository.findByCode(otpCode).orElseThrow();
    }

    @Override
    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public void findExpiredCodes() throws Exception {
        List<OTP> otpList = otpRepository.findAllExpiredAndNewOTPs();
        List<TransactionAmountDTO> transactionAmountDTOList = new ArrayList<>();
        for (OTP otp : otpList) {
            otp.expired();
            TransactionAmountDTO transactionAmountDTO = new TransactionAmountDTO(otp.getUser().getNationalId(),otp.getAmount());
            transactionAmountDTOList.add(transactionAmountDTO);
        }
        otpRepository.saveAll(otpList);
//        ResponseEntity<String> response = educationBalanceClient.reverseAmounts(transactionAmountDTOList);
//        if(!response.getStatusCode().equals(HttpStatus.OK)){
//            throw new Exception("Error in balance system");
//        }
    }
}
