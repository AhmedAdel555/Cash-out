package com.ahlymomkn.cashout.payload;

import java.math.BigDecimal;

public class TransactionAmountDTO {
    private BigDecimal amount;

    private String userNationalId;

    public TransactionAmountDTO() {
    }

    public TransactionAmountDTO(BigDecimal amount, String userNationalId) {
        this.amount = amount;
        this.userNationalId = userNationalId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUserNationalId() {
        return userNationalId;
    }

    public void setUserNationalId(String userNationalId) {
        this.userNationalId = userNationalId;
    }
}
