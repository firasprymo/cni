package com.example.cni.security.services.impl;

import com.example.cni.models.ERole;
import com.example.cni.models.Role;
import com.example.cni.models.User;
import com.example.cni.payload.request.SignupRequest;
import com.example.cni.payload.response.MessageResponse;
import com.example.cni.repositories.RoleRepository;
import com.example.cni.repositories.UserRepository;
import com.example.cni.security.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Utilisateur non trouvable");
        });
    }

    @Override
    public User addUser(SignupRequest signUpRequest) throws MessageResponse {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new MessageResponse("Error: Username is already taken!");
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new MessageResponse("Error: Email is already in use!");
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword())
                , signUpRequest.getAuthorized1()
                , signUpRequest.getAuthorized2()
                , signUpRequest.getAuthorized3()
        );

        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "user":
                        Role modRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                }
            });
        }

        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public User editUser(Long id, SignupRequest signUpRequest) throws MessageResponse {
        User user = userRepository.findById(id).orElseThrow(() ->
                new MessageResponse("User doesnt exist")

        );
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setAuthorized1(signUpRequest.getAuthorized1());
        user.setAuthorized2(signUpRequest.getAuthorized2());
        user.setAuthorized3(signUpRequest.getAuthorized3());
        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "user":
                        Role modRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                        break;
                }
            });
        }
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
