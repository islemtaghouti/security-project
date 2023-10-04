package com.example.springsecuritytuto.sec.service;

import com.example.springsecuritytuto.sec.dto.UserRequest;
import com.example.springsecuritytuto.sec.dto.UserResponse;
import com.example.springsecuritytuto.sec.entities.AppRole;
import com.example.springsecuritytuto.sec.entities.AppUser;
import com.example.springsecuritytuto.sec.reppo.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountService {
    UserResponse addNewUser(UserRequest appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoletoUser(String username, String rolename);
    UserResponse loadUserByUsername(String username);
    List<UserResponse> listUsers();
}
