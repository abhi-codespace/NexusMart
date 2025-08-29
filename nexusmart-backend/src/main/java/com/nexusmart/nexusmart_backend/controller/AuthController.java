package com.nexusmart.nexusmart_backend.controller;

import com.nexusmart.nexusmart_backend.dto.AuthRequest;
import com.nexusmart.nexusmart_backend.dto.AuthResponse;
import com.nexusmart.nexusmart_backend.dto.RegisterRequest;
import com.nexusmart.nexusmart_backend.securityService.AuthService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse>login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.o(authService.register(request));
    }
}
