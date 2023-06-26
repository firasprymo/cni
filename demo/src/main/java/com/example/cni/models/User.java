package com.example.cni.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })

public class User {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @NotBlank
	  @Size(max = 20)
	  private String username;

	  @NotBlank
	  @Size(max = 50)
	  @Email
	  private String email;
	private Boolean authorized1;
	private Boolean authorized2;
	private Boolean authorized3;

	  @NotBlank
	  @Size(max = 120)
	  private String password;

	public Boolean getAuthorized3() {
		return authorized3;
	}

	public void setAuthorized3(Boolean authorized3) {
		this.authorized3 = authorized3;
	}public Boolean getAuthorized2() {
		return authorized2;
	}

	public void setAuthorized2(Boolean authorized2) {
		this.authorized2 = authorized2;
	}
	public Boolean getAuthorized1() {
		return authorized1;
	}

	public void setAuthorized1(Boolean authorized1) {
		this.authorized1 = authorized1;
	}


	  @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(  name = "user_roles", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id"))
	  private Set<Role> roles = new HashSet<>();

	public User() {
	}

	  public User(String username, String email, String password, Boolean authorized1,
				  Boolean authorized2, Boolean authorized3) {
	    this.username = username;
	    this.email = email;
	    this.password = password;
	    this.authorized1 = authorized1;
	    this.authorized2 = authorized2;
	    this.authorized3 = authorized3;
	  }

	public Long getId() {
	    return id;
	  }

	  public void setId(Long id) {
	    this.id = id;
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

	  public Set<Role> getRoles() {
	    return roles;
	  }

	  public void setRoles(Set<Role> roles) {
	    this.roles = roles;
	  }
}
