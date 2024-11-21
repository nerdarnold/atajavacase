package com.atacase.auth.controller;

import com.atacase.auth.service.AuthService;
import com.atacase.auth.dto.LoginRequest;
import com.atacase.auth.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = authService.login(loginRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/verify-token")
    public boolean verifyToken(@RequestHeader("Authorization") String token) {
        return authService.verifyToken(token);
    }
}