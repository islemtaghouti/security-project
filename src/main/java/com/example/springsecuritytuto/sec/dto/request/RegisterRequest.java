package com.example.springsecuritytuto.sec.dto.request;

import com.example.springsecuritytuto.sec.entities.UserProfile;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private UserProfile profile;
}
