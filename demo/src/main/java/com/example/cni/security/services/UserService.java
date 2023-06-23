package com.example.cni.security.services;


import com.example.cni.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void deleteUser(Long id);
}
