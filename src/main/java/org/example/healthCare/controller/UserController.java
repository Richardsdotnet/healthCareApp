package org.example.healthCare.controller;

import org.example.healthCare.dto.request.UserLoginRequest;
import org.example.healthCare.dto.request.UserRegistrationRequest;
import org.example.healthCare.dto.response.ApiResponse;
import org.example.healthCare.exceptions.UserLoginException;
import org.example.healthCare.exceptions.UserRegistrationException;
import org.example.healthCare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("createAccount/{id}")
    public ResponseEntity<?> createAccount(@RequestBody UserRegistrationRequest user) throws UserRegistrationException {
        return new ResponseEntity<>(new ApiResponse(true, userService.createAccount(user)), HttpStatus.CREATED);
    }
    @GetMapping("signIn")
    public ResponseEntity<?> signIn(@RequestBody UserLoginRequest user) throws UserLoginException {

            return new ResponseEntity<>(new ApiResponse(true, userService.signIn(user)), HttpStatus.NOT_FOUND);
        }
    }

