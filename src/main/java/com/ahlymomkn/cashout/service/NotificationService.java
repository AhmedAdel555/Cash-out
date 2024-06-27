package com.ahlymomkn.cashout.service;

import com.ahlymomkn.cashout.model.entity.Notification;
import com.ahlymomkn.cashout.model.entity.User;
import com.ahlymomkn.cashout.payload.NotificationRequestDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationService {
    public List<Notification> retrieveUserNotifications(Integer userId);

    public void saveBalanceNotificationsList(List<NotificationRequestDTO> balanceNotificationDTOList) throws BadRequestException;

    public void SaveNotification(User user, String notificationTitle , String notificationBody);
}