package com.nexusmart.nexusmart_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nexusmart.nexusmart_backend.entity.User;
import com.nexusmart.nexusmart_backend.repository.UserRepository;
import com.nexusmart.nexusmart_backend.serviceInterface.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    

    @Override
    public  User getUserById(Long id) {
        return userRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Product not found with id "+ id));
    }


        @Override
        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

        @Override
        public User registerUser(User user) {
            return userRepository.save(user);
        }

        @Override
        public User updateUser(Long id,User user){
            User existing =getUserById(id);
            existing.setUsername(user.getUsername());
            existing.setEmail(user.getEmail());
            existing.setPassword(user.getPassword());
            return userRepository.save(existing);
        }

        @Override
        public void deleteUser(Long id){
            userRepository.deleteById(id);
        }
    
}
