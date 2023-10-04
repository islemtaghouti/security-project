package com.example.springsecuritytuto;

import com.example.springsecuritytuto.sec.dto.UserRequest;
import com.example.springsecuritytuto.sec.entities.AppRole;
import com.example.springsecuritytuto.sec.entities.AppUser;
import com.example.springsecuritytuto.sec.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityTutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityTutoApplication.class, args);
	}
	@Bean
	CommandLineRunner start(AccountService accountService) {
		return  args -> {
			accountService.addNewRole(new AppRole(null,"USER"));
			accountService.addNewRole(new AppRole(null,"ADMIN"));
			accountService.addNewRole(new AppRole(null,"CUSTOMER_MANAGER"));
			accountService.addNewRole(new AppRole(null,"PRODUCT_MANAGER"));
			accountService.addNewRole(new AppRole(null,"BILSS_MANAGER"));
			accountService.addNewUser(new UserRequest("user1","12345"));
			accountService.addNewUser(new UserRequest("admin","12345"));
			accountService.addNewUser(new UserRequest("user2","12345"));
			accountService.addNewUser(new UserRequest("user3","12345"));
			accountService.addNewUser(new UserRequest("user4","12345"));
			accountService.addRoletoUser("user1","USER");
			accountService.addRoletoUser("admin","ADMIN");
			accountService.addRoletoUser("admin","USER");
			accountService.addRoletoUser("user2","USER");
			accountService.addRoletoUser("user2","CUSTOMER_MANAGER");
			accountService.addRoletoUser("user3","USER");
			accountService.addRoletoUser("user3","PRODUCT_MANAGER");
			accountService.addRoletoUser("user4","USER");
			accountService.addRoletoUser("user4","BILSS_MANAGER");
		};
	}

}
