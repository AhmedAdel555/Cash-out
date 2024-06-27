package com.ahlymomkn.cashout.controller;

import com.ahlymomkn.cashout.model.entity.User;
import com.ahlymomkn.cashout.payload.UserDTO;
import com.ahlymomkn.cashout.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable Integer userId) {
        User user = this.userService.findUserById(userId);
        UserDTO userDTO = new UserDTO(user.getId(), user.getNationalId(), user.getUsername(), user.getMobileNumber(), user.getImageUrl());
        return ResponseEntity.ok(userDTO);
    }
}
