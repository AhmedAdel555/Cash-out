package com.ahlymomkn.cashout.payload;

import java.math.BigDecimal;

public class TransactionAmountDTO {
    private String nationalId;
    private String transactionReference;
    private String reference2;
    private BigDecimal transactionAmount;
    private String type;
    private String status;

    public TransactionAmountDTO(String nationalId, BigDecimal transactionAmount) {
        this.nationalId = nationalId;
        this.transactionAmount = transactionAmount;
    }

    public TransactionAmountDTO(String nationalId, String transactionReference, String reference2, BigDecimal transactionAmount, String type, String status) {
        this.nationalId = nationalId;
        this.transactionReference = transactionReference;
        this.reference2 = reference2;
        this.transactionAmount = transactionAmount;
        this.type = type;
        this.status = status;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public String getReference2() {
        return reference2;
    }

    public void setReference2(String reference2) {
        this.reference2 = reference2;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
