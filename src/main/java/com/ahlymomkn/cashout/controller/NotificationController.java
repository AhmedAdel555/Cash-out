package com.ahlymomkn.cashout.controller;

import com.ahlymomkn.cashout.model.entity.Notification;
import com.ahlymomkn.cashout.model.entity.User;
import com.ahlymomkn.cashout.payload.NotificationRequestDTO;
import com.ahlymomkn.cashout.payload.NotificationResposeDTO;
import com.ahlymomkn.cashout.payload.UserDTO;
import com.ahlymomkn.cashout.service.NotificationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<NotificationResposeDTO>> retrieveUserNotification(@PathVariable("userId") Integer userId){
        List<Notification> notifications = this.notificationService.retrieveUserNotifications(userId);
        List<NotificationResposeDTO> notificationResposeDTOList = new ArrayList<>();
        for (Notification notification : notifications){
            NotificationResposeDTO notificationResposeDTO = new NotificationResposeDTO(notification.getId(), notification.getTitle(), notification.getBody());
            notificationResposeDTOList.add(notificationResposeDTO);
        }
        return ResponseEntity.ok(notificationResposeDTOList);
    }

    @PostMapping("/balanceNotification")
    public ResponseEntity<String> saveBalanceNotification(@Valid @RequestBody NotificationRequestDTO balanceNotificationDTO) throws BadRequestException {
        return notificationService.saveBalanceNotification(balanceNotificationDTO);
    }
}