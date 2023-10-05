package com.example.springsecuritytuto.sec.service;

import com.example.springsecuritytuto.sec.dto.request.AuthenticationRequest;
import com.example.springsecuritytuto.sec.dto.request.RegisterRequest;
import com.example.springsecuritytuto.sec.dto.response.AuthenticationResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthentificationService {
    AuthenticationResponse register(RegisterRequest registerRequest);
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
