package com.example.cni.security.services;


import com.example.cni.models.User;
import com.example.cni.payload.request.SignupRequest;
import com.example.cni.payload.response.MessageResponse;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(Long id);
    User editUser(Long id, SignupRequest user) throws MessageResponse;

    User addUser(SignupRequest user) throws MessageResponse;

    void deleteUser(Long id);
}
