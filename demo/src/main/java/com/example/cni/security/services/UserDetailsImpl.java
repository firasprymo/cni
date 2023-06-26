package com.example.cni.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.cni.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String username;

  private String email;



  private Boolean authorized1;
  private Boolean authorized2;
  private Boolean authorized3;

  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(Long id, String username, String email, String password,Boolean authorized1,Boolean authorized2,Boolean authorized3,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.username = username;
    this.authorized1 = authorized1;
    this.authorized2 = authorized2;
    this.authorized3 = authorized3;
    this.email = email;
    this.password = password;
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(User user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImpl(
        user.getId(), 
        user.getUsername(), 
        user.getEmail(),
        user.getPassword(), 
        user.getAuthorized1(),
        user.getAuthorized2(),
        user.getAuthorized3(),
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
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
  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
