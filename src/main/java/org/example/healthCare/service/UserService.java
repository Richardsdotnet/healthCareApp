package org.example.healthCare.service;

import lombok.RequiredArgsConstructor;
import org.example.healthCare.dto.request.UserLoginRequest;
import org.example.healthCare.dto.request.UserRegistrationRequest;
import org.example.healthCare.dto.response.UserLoginResponse;
import org.example.healthCare.dto.response.UserRegistrationResponse;
import org.example.healthCare.exceptions.UserLoginException;
import org.example.healthCare.exceptions.UserRegistrationException;
import org.example.healthCare.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService  {
    UserRegistrationResponse createAccount (UserRegistrationRequest userRegistrationRequest) throws  UserRegistrationException;

    UserLoginResponse signIn(UserLoginRequest userLoginRequest) throws UserLoginException;

    List<User> users();


    void deleteAll();
}
