package com.mohamed.Entities;

import com.mohamed.Enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
