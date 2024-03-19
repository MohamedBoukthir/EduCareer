package com.mohamed.Services.Authentication;

import com.mohamed.Dto.RegisterRequest;
import com.mohamed.Dto.UserDto;
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

    // Default User Account Creation
    @Override
    public UserDto createUser(RegisterRequest registerRequest) {
        User user = new User();
        user.setFullName(registerRequest.getFullName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(registerRequest.getPassword()));
        user.setBio(registerRequest.getBio());
        user.setCountry(registerRequest.getCountry());
        user.setGithubLink(registerRequest.getGithubLink());
        user.setLinkedinLink(registerRequest.getLinkedinLink());
        user.setRole(Role.USER);
        User createdUser = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());
        return userDto;
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
