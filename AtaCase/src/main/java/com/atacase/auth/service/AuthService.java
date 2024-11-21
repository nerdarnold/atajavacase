package com.atacase.auth.service;

import com.atacase.auth.dto.LoginRequest;
import com.atacase.auth.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    boolean verifyToken(String token);
}