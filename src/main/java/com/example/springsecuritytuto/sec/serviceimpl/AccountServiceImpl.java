package com.example.springsecuritytuto.sec.serviceimpl;

import com.example.springsecuritytuto.sec.dto.request.UserRequest;
import com.example.springsecuritytuto.sec.dto.response.UserResponse;
import com.example.springsecuritytuto.sec.entities.AppRole;
import com.example.springsecuritytuto.sec.entities.AppUser;
import com.example.springsecuritytuto.sec.mapper.AppUserMapper;
import com.example.springsecuritytuto.sec.reppo.AppRoleRepository;
import com.example.springsecuritytuto.sec.reppo.AppUserRepository;
import com.example.springsecuritytuto.sec.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AppUserRepository appUserRepository;

    private final  AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserResponse addNewUser(UserRequest appUser) {
        AppUser user = AppUser.builder().email(appUser.getUsername()).
                password(passwordEncoder.encode(appUser.getPassword())).build();
        appUserRepository.save(user);
        return AppUserMapper.INSTANCE.entityToDto(user);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoletoUser(String username, String rolename) {
        AppUser appUser = appUserRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
        AppRole appRole = appRoleRepository.findByRoleName(rolename);
        appUser.getAppRoles().add(appRole);
    }
    @Override
    public List<UserResponse> listUsers() {
        return AppUserMapper.INSTANCE.listEntityToDto(appUserRepository.findAll());
    }
}
