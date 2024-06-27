package com.ahlymomkn.cashout.service.impl;

import com.ahlymomkn.cashout.model.entity.User;
import com.ahlymomkn.cashout.repository.UserRepository;
import com.ahlymomkn.cashout.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Integer userId) {
        return userRepository.findById(userId).orElseThrow();
    }
}
