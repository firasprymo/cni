package com.example.cni.payload.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> role;

    private Boolean authorized1;
    private Boolean authorized2;
    private Boolean authorized3;
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;


    public Boolean getAuthorized1() {
        return authorized1;
    }

    public void setAuthorized1(Boolean authorized1) {
        this.authorized1 = authorized1;
    }

    public Boolean getAuthorized2() {
        return authorized2;
    }

    public void setAuthorized2(Boolean authorized2) {
        this.authorized2 = authorized2;
    }

    public Boolean getAuthorized3() {
        return authorized3;
    }

    public void setAuthorized3(Boolean authorized3) {
        this.authorized3 = authorized3;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
