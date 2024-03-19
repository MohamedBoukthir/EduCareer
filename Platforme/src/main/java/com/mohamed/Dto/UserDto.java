package com.mohamed.Dto;

import com.mohamed.Enums.Role;
import lombok.Data;

@Data
public class UserDto {

    private Long Id;
    private String fullName;
    private String email;
    private String password;
    private String bio;
    private String country;
    private String GithubLink;
    private String LinkedinLink;
    private Role role;

}
