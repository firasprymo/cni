package com.example.cni.security.services.impl;

import com.example.cni.models.User;
import com.example.cni.repositories.UserRepository;
import com.example.cni.security.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public void deleteUser(Long id) {
         userRepository.deleteById(id);
    }
}
