package org.example.healthCare.utils;

import org.example.healthCare.dto.request.UserLoginRequest;
import org.example.healthCare.dto.request.UserRegistrationRequest;
import org.example.healthCare.dto.response.UserLoginResponse;
import org.example.healthCare.dto.response.UserRegistrationResponse;
import org.example.healthCare.models.User;

public class Mapper {
    public static User map(UserRegistrationRequest request) {
        return User.builder()
                .password(request.getPassword())
                .email(request.getEmail())
                .name(request.getName())
                .build();
    }

    public static UserRegistrationResponse map(User savedUser){
        return UserRegistrationResponse.builder()
                .id(savedUser.getId())
                .message("Account Successfully Created")
                .name(savedUser.getName())
                .build();
    }

    public static User map(UserLoginRequest request) {
        return User.builder()
                .password(request.getPassword())
                .email(request.getEmail())
                .build();
    }

    public static UserLoginResponse mapResponse(User user){
        return UserLoginResponse.builder()
                .isLoggedIn(true)
                .message("Login Successful")
                .email(user.getEmail())
                .build();
    }




}
