package com.ahlymomkn.cashout.model.entity;

import com.ahlymomkn.cashout.model.enums.OTPStatus;
import com.ahlymomkn.cashout.util.OTPStatus.ExpiredOTPState;
import com.ahlymomkn.cashout.util.OTPStatus.NewOTPState;
import com.ahlymomkn.cashout.util.OTPStatus.OTPState;
import com.ahlymomkn.cashout.util.OTPStatus.PaidOTPState;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "otps")
public class OTP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "expiration_date", nullable = false)
    private LocalDateTime expirationDate;
    @Column(name = "code" ,unique = true, nullable = false)
    private String code;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "state", nullable = false)
    private OTPStatus state;

    @Transient
    private OTPState stateBehavior;

    @PostLoad
    private void loadStateBehavior() {
        switch (state) {
            case NEW:
                this.stateBehavior = new NewOTPState(this);
                break;
            case PAID:
                this.stateBehavior = new PaidOTPState(this);
                break;
            case EXPIRED:
                this.stateBehavior = new ExpiredOTPState(this);
                break;
        }
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public OTP() {
    }

    public OTP(BigDecimal amount, LocalDateTime expirationDate, String code, OTPStatus state) {
        this.amount = amount;
        this.expirationDate = expirationDate;
        this.code = code;
        this.state = state;
        this.stateBehavior = new NewOTPState(this);
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

    public OTPStatus getState() {
        return state;
    }

    public void setState(OTPStatus state) {
        this.state = state;
    }

    public void paid() {
        this.stateBehavior.paid();
    }

    public void expired() {
        this.stateBehavior.expired();
    }

    public OTPState getStateBehavior() {
        return stateBehavior;
    }

    public void setStateBehavior(OTPState stateBehavior) {
        this.stateBehavior = stateBehavior;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OTP otp = (OTP) o;
        return Objects.equals(id, otp.id) && Objects.equals(amount, otp.amount) && Objects.equals(expirationDate, otp.expirationDate) && Objects.equals(code, otp.code) && state == otp.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, expirationDate, code, state);
    }
}
