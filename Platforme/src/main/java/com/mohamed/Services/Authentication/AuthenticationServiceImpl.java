package com.mohamed.Services.Authentication;

import com.mohamed.Entities.User;
import com.mohamed.Enums.Role;
import com.mohamed.Repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository userRepository;

    // Admin Account Will Generate By Default
    @PostConstruct
    public void AdminAccountCreation(){
        User adminAccount = userRepository.findByRole(Role.ADMIN);
        if (adminAccount == null) {
            User newAdminAccount = new User();
            newAdminAccount.setFullName("Platform Admin");
            newAdminAccount.setEmail("admin@gmail.com");
            newAdminAccount.setBio("Hello From The Admin Account.");
            newAdminAccount.setCountry("TUNISIA");
            newAdminAccount.setGithubLink("");
            newAdminAccount.setLinkedinLink("");
            newAdminAccount.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(newAdminAccount);
            System.out.println(" * * * Welcome " + newAdminAccount.getFullName() + " * * * ");
        }
    }

}
