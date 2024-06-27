package com.ahlymomkn.cashout.payload;

import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OTPDetailsDTO {

    private Integer id;
    private BigDecimal amount;
    private LocalDateTime expirationDate;
    private String code;

    private UserDTO userDTO;

    public OTPDetailsDTO() {
    }

    public OTPDetailsDTO(Integer id, BigDecimal amount, LocalDateTime expirationDate, String code) {
        this.id = id;
        this.amount = amount;
        this.expirationDate = expirationDate;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
