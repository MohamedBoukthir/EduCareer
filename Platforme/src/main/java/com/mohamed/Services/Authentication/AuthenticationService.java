package com.mohamed.Services.Authentication;

import com.mohamed.Dto.RegisterRequest;
import com.mohamed.Dto.UserDto;

public interface AuthenticationService {

    UserDto createUser(RegisterRequest registerDto);
    boolean hasUserWithEmail(String email);

}
