package com.example.springsecuritytuto.sec.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email",unique = true,nullable = false,length = 100,updatable = false)
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Column(name = "first_name", nullable = false,length = 250)
    private String firstName;

    @Column(name = "last_name",nullable = false,length = 250)
    private String lastName;
    @Column(name = "last_login")
    private LocalDateTime lastLogin;
    @Column(name = "enabled",nullable = false)
    private Boolean enabled;
    @Column(name = "account_expired",nullable = false)
    private Boolean accountExpired;
    @Column(name = "account_locked",nullable = false)
    private Boolean accountLocked;

    @Column(name = "credentials_expired",nullable = false)
    private Boolean credentialsExpired;
    @Column(name = "profile",length = 50,nullable = false)
    @Enumerated(EnumType.STRING)
    private UserProfile profile;
    @ManyToMany(fetch = FetchType.EAGER  )
    private Collection<AppRole> appRoles = new ArrayList<>();
}
