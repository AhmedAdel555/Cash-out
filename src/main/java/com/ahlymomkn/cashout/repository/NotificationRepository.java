package com.ahlymomkn.cashout.repository;

import com.ahlymomkn.cashout.model.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    @Query(value = "select *  from notifications  where user_id = ?1", nativeQuery = true)
    List<Notification> findAllUserNotification(Integer userId);

}
