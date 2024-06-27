package com.ahlymomkn.cashout.service.impl;

import com.ahlymomkn.cashout.exception.ConflictException;
import com.ahlymomkn.cashout.model.entity.User;
import com.ahlymomkn.cashout.payload.JwtAuthResponse;
import com.ahlymomkn.cashout.payload.LoginDTO;
import com.ahlymomkn.cashout.payload.RegisterDTO;
import com.ahlymomkn.cashout.payload.UserDTO;
import com.ahlymomkn.cashout.repository.UserRepository;
import com.ahlymomkn.cashout.service.AuthService;
import com.ahlymomkn.cashout.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public JwtAuthResponse login(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getNationalId(),
                        loginDTO.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        User user = userRepository.findByNationalIdOrMobileNumber(loginDTO.getNationalId(), loginDTO.getNationalId()).orElseThrow();
        UserDTO userDTO = new UserDTO(user.getId(), user.getNationalId(), user.getUsername(), user.getMobileNumber(), user.getImageUrl());
        jwtAuthResponse.setUserDTO(userDTO);
        return jwtAuthResponse;
    }

    @Override
    public String register(RegisterDTO registerDTO) {

        Optional<User> existUser = userRepository.findByNationalId(registerDTO.getNationalId());

        if(existUser.isPresent()){
            throw new ConflictException(HttpStatus.BAD_REQUEST,"user already exists");
        }

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setGender(registerDTO.getGender());
        user.setMobileNumber(registerDTO.getMobileNumber());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setNationalId(registerDTO.getNationalId());
        user.setImageUrl(registerDTO.getImageUrl());

        userRepository.save(user);

        return "user registered successfully";
    }
}
