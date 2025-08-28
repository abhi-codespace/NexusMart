package com.nexusmart.nexusmart_backend.serviceInterface;

import java.util.List;

import com.nexusmart.nexusmart_backend.entity.User;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User registerUser(User user);

    User updateUser(Long id,User user);

    void deleteUser(Long id);

}
