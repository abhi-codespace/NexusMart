package com.nexusmart.nexusmart_backend.services;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.nexusmart.nexusmart_backend.entity.User;
import com.nexusmart.nexusmart_backend.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findByUsername(username);

        User userEntity = userOpt.orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + username));

        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles(userEntity.getRoles().stream().map(Enum::name).toArray(String[]::new))
                .build();
    }
}
