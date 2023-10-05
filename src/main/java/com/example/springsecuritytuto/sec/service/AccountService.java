package com.example.springsecuritytuto.sec.service;
import com.example.springsecuritytuto.sec.dto.request.UserRequest;
import com.example.springsecuritytuto.sec.dto.response.UserResponse;
import com.example.springsecuritytuto.sec.entities.AppRole;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountService {
    UserResponse addNewUser(UserRequest appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoletoUser(String username, String rolename);
    List<UserResponse> listUsers();
}
