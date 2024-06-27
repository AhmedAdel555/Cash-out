package com.ahlymomkn.cashout.service;

import com.ahlymomkn.cashout.payload.JwtAuthResponse;
import com.ahlymomkn.cashout.payload.LoginDTO;
import com.ahlymomkn.cashout.payload.RegisterDTO;

public interface AuthService {
    public JwtAuthResponse login(LoginDTO loginDTO);
    public String register(RegisterDTO registerDTO);
}
