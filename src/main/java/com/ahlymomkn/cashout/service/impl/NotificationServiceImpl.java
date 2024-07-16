package com.ahlymomkn.cashout.service.impl;

import com.ahlymomkn.cashout.model.entity.Notification;
import com.ahlymomkn.cashout.model.entity.User;
import com.ahlymomkn.cashout.payload.NotificationRequestDTO;
import com.ahlymomkn.cashout.repository.NotificationRepository;
import com.ahlymomkn.cashout.repository.UserRepository;
import com.ahlymomkn.cashout.service.NotificationService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Override
    public void SaveNotification(User user, String notificationTitle, String notificationBody) {
    }
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }
    @Override
    @Transactional
    public List<Notification> retrieveUserNotifications(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return notificationRepository.findAllUserNotification(user.getId());
    }

    @Override
    @Transactional
    public ResponseEntity<String> saveBalanceNotification(NotificationRequestDTO balanceNotificationDTO) throws BadRequestException {
            Optional<User> user = userRepository.findByNationalId(balanceNotificationDTO.getNationalId());
            if (user.isEmpty()){
                throw new BadRequestException("user with national id" + balanceNotificationDTO.getNationalId());
            }
            Notification notification = new Notification();
            notification.setTitle(balanceNotificationDTO.getTitle());
            notification.setBody(balanceNotificationDTO.getBody());
            notification.setEffectiveDate(LocalDateTime.now());
            notification.setUser(user.get());
            notificationRepository.save(notification);
            return  ResponseEntity.ok("Process Completed Successfully");
    }

}
