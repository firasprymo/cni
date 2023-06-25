package com.example.cni.controllers;

import com.example.cni.models.ERole;
import com.example.cni.models.Role;
import com.example.cni.models.User;
import com.example.cni.payload.request.SignupRequest;
import com.example.cni.payload.response.JwtResponse;
import com.example.cni.payload.response.MessageResponse;
import com.example.cni.security.services.UserDetailsImpl;
import com.example.cni.security.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {

        return ResponseEntity.ok(userService.getUser(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> editUser(@PathVariable("id") Long id, @RequestBody SignupRequest user) throws MessageResponse {

        return ResponseEntity.ok(userService.editUser(id, user));
    }

    @PostMapping("/")
    public ResponseEntity<User> addUser(@RequestBody SignupRequest user) throws MessageResponse {

        return ResponseEntity.ok(userService.addUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
