package com.example.springsecuritytuto.sec.web;

import com.example.springsecuritytuto.sec.dto.request.AuthenticationRequest;
import com.example.springsecuritytuto.sec.dto.request.RegisterRequest;
import com.example.springsecuritytuto.sec.dto.response.AuthenticationResponse;
import com.example.springsecuritytuto.sec.service.AuthentificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthentificationService authentificationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authentificationService.register(registerRequest));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest registerRequest){
        return ResponseEntity.ok(authentificationService.authenticate(registerRequest));
    }
}
