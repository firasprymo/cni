package com.example.cni.payload.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;


    private Boolean authorized1;
    private Boolean authorized2;
    private Boolean authorized3;
    private List<String> roles;

    public JwtResponse(String accessToken, Long id, String username, String email,
                       Boolean authorized1,
                       Boolean authorized2,
                       Boolean authorized3,
                       List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.authorized1 = authorized1;
        this.authorized2 = authorized2;
        this.authorized3 = authorized3;
        this.roles = roles;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

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

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }
}
