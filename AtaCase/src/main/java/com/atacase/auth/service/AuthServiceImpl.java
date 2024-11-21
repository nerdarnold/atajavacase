package com.atacase.auth.service;

import com.atacase.auth.dto.LoginRequest;
import com.atacase.auth.dto.LoginResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Value("${firebase.api.key}")
    private String firebaseApiKey;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return new LoginResponse("mocked-token");
    }

    @Override
    public boolean verifyToken(String token) {
        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
            return decodedToken != null;
        } catch (Exception e) {
            return false;
        }
    }
}