package com.example.springsecuritytuto.sec.serviceimpl;
import com.example.springsecuritytuto.sec.dto.CustomerUserDetails;
import com.example.springsecuritytuto.sec.entities.AppUser;
import com.example.springsecuritytuto.sec.reppo.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByEmail(username).orElseThrow (
                () -> new UsernameNotFoundException("User not found [toEmail: " + username + "]"));
            return  CustomerUserDetails.builder().enabled(appUser.getEnabled()).accountExpired(appUser.getAccountExpired()).accountLocked(appUser.getAccountLocked()).credentialsExpired(appUser.getCredentialsExpired()).email(appUser.getEmail()).password(appUser.getPassword()).firstName(appUser.getFirstName()).lastName(appUser.getLastName()).build();
    }
}
