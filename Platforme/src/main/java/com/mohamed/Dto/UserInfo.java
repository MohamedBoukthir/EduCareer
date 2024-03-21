package com.mohamed.Dto;

import lombok.Data;

@Data
public class UserInfo {

    private Long Id;
    private String fullName;
    private String email;
    private String password;
    private String bio;
    private String country;
    private String GithubLink;
    private String LinkedinLink;
    private String pic;

}
