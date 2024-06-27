package com.ahlymomkn.cashout.service.impl;

import com.ahlymomkn.cashout.model.entity.Notification;
import com.ahlymomkn.cashout.model.entity.User;
import com.ahlymomkn.cashout.payload.NotificationRequestDTO;
import com.ahlymomkn.cashout.repository.NotificationRepository;
import com.ahlymomkn.cashout.repository.UserRepository;
import com.ahlymomkn.cashout.service.NotificationService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

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
    public void saveBalanceNotificationsList(List<NotificationRequestDTO> balanceNotificationDTOList) throws BadRequestException {
        // check the existing of the user
        // if one or more users dosen't exist the process will not be completed and rollback
        for(NotificationRequestDTO balanceNotification: balanceNotificationDTOList){
            Optional<User> user = userRepository.findByNationalId(balanceNotification.getNationalId());
            if (user.isEmpty()){
                throw new BadRequestException("user with national id" + balanceNotification.getNationalId());
            }
            SaveNotification(user.get(), balanceNotification.getTitle(), balanceNotification.getBody());
        }
    }

    @Override
    @Transactional
    public void SaveNotification(User user, String notificationTitle ,String notificationBody) {
        Notification notification = new Notification();
        notification.setTitle(notificationTitle);
        notification.setBody(notificationBody);
        notification.setUser(user);
        notificationRepository.save(notification);
    }
}
