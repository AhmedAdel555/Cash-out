package com.ahlymomkn.cashout.repository;

import com.ahlymomkn.cashout.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    @Query(value = "SELECT * FROM users WHERE national_id = ?1",nativeQuery = true)
    Optional<User> findByNationalId(String nationalId);

    @Query("SELECT u FROM User u WHERE u.nationalId = :nationalId OR u.mobileNumber = :mobileNumber")
    Optional<User> findByNationalIdOrMobileNumber(@Param("nationalId") String nationalId, @Param("mobileNumber") String mobileNumber);
}
