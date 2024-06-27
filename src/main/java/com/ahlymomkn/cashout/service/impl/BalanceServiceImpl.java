package com.ahlymomkn.cashout.service.impl;

import com.ahlymomkn.cashout.model.entity.OTP;
import com.ahlymomkn.cashout.model.entity.User;
import com.ahlymomkn.cashout.model.enums.OTPStatus;
import com.ahlymomkn.cashout.payload.TransactionAmountDTO;
import com.ahlymomkn.cashout.repository.OTPRepository;
import com.ahlymomkn.cashout.service.BalanceService;
import com.ahlymomkn.cashout.service.NotificationService;
import com.ahlymomkn.cashout.util.CodeGenerator;
import com.ahlymomkn.cashout.util.EducationBalanceClient;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final EducationBalanceClient educationBalanceClient;
    private final OTPRepository otpRepository;

    private final NotificationService notificationService;

    @Autowired
    public BalanceServiceImpl(EducationBalanceClient educationBalanceClient, OTPRepository otpRepository, NotificationService notificationService) {
        this.educationBalanceClient = educationBalanceClient;
        this.otpRepository = otpRepository;
        this.notificationService = notificationService;
    }

    @Override
    public BigDecimal findUserBalance(User user) {
        return BigDecimal.valueOf(20000);
//        return educationBalanceClient.findUserBalance(user.getNationalId()).getBody();
    }

    @Override
    @Transactional
    public String authorizeAmount(User user , BigDecimal amount) throws BadRequestException {
        String otpCode = CodeGenerator.generateCode();
        OTP otp = new OTP(amount, LocalDateTime.now().plusMinutes(15) , otpCode, OTPStatus.NEW);
        otp.setUser(user);
        otpRepository.save(otp);
//        TransactionAmountDTO transactionAmountDTO = new TransactionAmountDTO(amount, user.getNationalId());
//        ResponseEntity<String> response =  educationBalanceClient.authorizeAmount(transactionAmountDTO);
//        if(!response.getStatusCode().equals(HttpStatus.OK)){
//            throw new BadRequestException(response.getBody());
//        }
        return otpCode;
    }

    @Override
    @Transactional
    public String cashoutAmount(String otpCode) throws BadRequestException {
        OTP otp = otpRepository.findByCode(otpCode).orElseThrow();
        if(otp.getExpirationDate().isBefore(LocalDateTime.now())){
            throw new BadRequestException("Expired Code");
        }
        otp.paid();
        otpRepository.save(otp);
//        TransactionAmountDTO transactionAmountDTO = new TransactionAmountDTO(otp.getAmount(), otp.getUser().getNationalId());
//        ResponseEntity<String> response = educationBalanceClient.cashoutAmount(transactionAmountDTO);
//        if(!response.getStatusCode().equals(HttpStatus.OK)){
//            throw new BadRequestException(response.getBody());
//        }
        String notificationBody = "Your withdrawal of " + otp.getAmount() + " has been completed successfully.";
        String notificationTitle = "withdrawal been completed successfully";
        notificationService.SaveNotification(otp.getUser(), notificationTitle ,notificationBody);
        return "Done";
    }
}
