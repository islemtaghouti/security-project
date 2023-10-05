package com.example.springsecuritytuto.sec.dto.response;

import com.example.springsecuritytuto.sec.entities.UserProfile;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime lastLogin;
    private Boolean enabled;
    private Boolean accountExpired;
    private Boolean accountLocked;
    private Boolean credentialsExpired;

    private UserProfile profile;
}
