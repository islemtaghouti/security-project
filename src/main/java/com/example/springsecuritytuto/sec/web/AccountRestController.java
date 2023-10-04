package com.example.springsecuritytuto.sec.web;

import com.example.springsecuritytuto.sec.dto.UserRequest;
import com.example.springsecuritytuto.sec.dto.UserResponse;
import com.example.springsecuritytuto.sec.entities.AppRole;
import com.example.springsecuritytuto.sec.entities.AppUser;
import com.example.springsecuritytuto.sec.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountRestController {
    private final AccountService accountService;
    @GetMapping(path = "/users")
    public List<UserResponse> appUserList(){
       return accountService.listUsers();
    }
    @PostMapping("/save")
    public UserResponse addUser(@RequestBody UserRequest userRequest){
        return accountService.addNewUser(userRequest);

    }
    @PostMapping("/addrole")
    public AppRole addrole(@RequestBody AppRole appRole) {
        return accountService.addNewRole(appRole);
    }
    @PostMapping("/affect-role")
    public void affectrole(@RequestBody String username,@RequestBody String rolename){
         accountService.addRoletoUser(username,rolename);
    }

}
