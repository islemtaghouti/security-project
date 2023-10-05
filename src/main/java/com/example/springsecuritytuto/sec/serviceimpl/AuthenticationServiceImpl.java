package com.example.springsecuritytuto.sec.serviceimpl;

import com.example.springsecuritytuto.sec.dto.CustomerUserDetails;
import com.example.springsecuritytuto.sec.dto.request.AuthenticationRequest;
import com.example.springsecuritytuto.sec.dto.request.RegisterRequest;
import com.example.springsecuritytuto.sec.dto.response.AuthenticationResponse;
import com.example.springsecuritytuto.sec.entities.AppUser;
import com.example.springsecuritytuto.sec.mapper.AuthenticationMapper;
import com.example.springsecuritytuto.sec.reppo.AppUserRepository;
import com.example.springsecuritytuto.sec.service.AuthentificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthentificationService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var appuser = AppUser.builder().firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .accountExpired(false)
                .accountLocked(false).credentialsExpired(false).enabled(true)
                .profile(registerRequest.getProfile()).build();
        return AuthenticationMapper.INSTANCE.entityToDto(appUserRepository.save(appuser));
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        appUserRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow(()->new UsernameNotFoundException("Email not found [toEmail: " + authenticationRequest.getEmail() + "]"));
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        CustomerUserDetails userDetails = (CustomerUserDetails) authentication.getPrincipal();
        var jwt = jwtService.generateToken(userDetails);
        return AuthenticationResponse.builder()
                .token(jwt)
                .accountExpired(userDetails.isAccountExpired())
                .accountLocked(userDetails.isAccountLocked())
                .credentialsExpired(userDetails.isCredentialsExpired())
                .email(userDetails.getEmail())
                .enabled(userDetails.isEnabled())
                .firstName(userDetails.getFirstName())
                .lastName(userDetails.getLastName())
                .lastLogin(userDetails.getLastLogin())
                .profile(userDetails.getProfile())
                .build();
    }
}
