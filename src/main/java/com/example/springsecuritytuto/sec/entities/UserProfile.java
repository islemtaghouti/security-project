package com.example.springsecuritytuto.sec.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserProfile {
    CLOUD_ADMIN("CLOUD_ADMIN"),
    COMPANY_ADMIN("COMPANY_ADMIN"),
    USER("USER");
    private final String profile;
}
