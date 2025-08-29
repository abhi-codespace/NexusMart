package com.nexusmart.nexusmart_backend.securityService;

import java.util.Set;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nexusmart.nexusmart_backend.dto.AuthRequest;
import com.nexusmart.nexusmart_backend.dto.AuthResponse;
import com.nexusmart.nexusmart_backend.dto.RegisterRequest;
import com.nexusmart.nexusmart_backend.entity.RoleType;
import com.nexusmart.nexusmart_backend.entity.User;
import com.nexusmart.nexusmart_backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    // private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    // Login
    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }

    // Register
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already taken");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());

        user.setRoles(Set.of(RoleType.USER));
        

        userRepository.save(user);

        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }
}

