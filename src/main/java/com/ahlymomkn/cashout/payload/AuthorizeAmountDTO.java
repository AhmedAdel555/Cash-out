package com.ahlymomkn.cashout.payload;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class AuthorizeAmountDTO {

    @Min(0)
    private Integer userId;

    @Min(1)
    private BigDecimal amount;

    public AuthorizeAmountDTO() {
    }

    public AuthorizeAmountDTO(Integer userId, BigDecimal amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
