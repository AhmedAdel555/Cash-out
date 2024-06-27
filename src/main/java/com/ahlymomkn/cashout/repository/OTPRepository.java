package com.ahlymomkn.cashout.repository;

import com.ahlymomkn.cashout.model.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OTPRepository extends JpaRepository<OTP, Integer> {
    Optional<OTP> findByCode(String code);

    @Query(value = "SELECT * FROM otps WHERE expiration_date < CURRENT_TIMESTAMP AND state = 'NEW'", nativeQuery = true)
    List<OTP> findAllExpiredAndNewOTPs();
}
