package org.example.healthCare.service;

import org.example.healthCare.dto.request.UserLoginRequest;
import org.example.healthCare.dto.request.UserRegistrationRequest;
import org.example.healthCare.dto.response.UserLoginResponse;
import org.example.healthCare.dto.response.UserRegistrationResponse;
import org.example.healthCare.exceptions.UserLoginException;
import org.example.healthCare.exceptions.UserRegistrationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class HealthCareUserServiceTest {
    @Autowired
    UserService userService;
    UserRegistrationResponse response;

    @BeforeEach void startAllTestWith(){
        userService.deleteAll();
        UserRegistrationRequest request = UserRegistrationRequest.builder()
                .name("John Malcom")
                .email("richardned@gmail.com")
                .password("P@ssw0rd")
                .build();
        try {
            response = userService.createAccount(request);
        } catch (UserRegistrationException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    void createAccount() {
     //   System.out.println("the response is: " + response);
        assertEquals("Account Successfully Created", response.getMessage());
        assertEquals(BigInteger.ONE.intValue(), userService.users().size());
       // System.out.println(userService.users().size());
    }


    @Test
    void loginCreatedAccount() throws UserLoginException {
        UserRegistrationResponse response = new UserRegistrationResponse();
        UserRegistrationRequest request = UserRegistrationRequest.builder()
                .name("John Malcom")
                .email("richardned@gmail.com")
                .password("P@ssw0rd")
                .build();

        try {
            response = userService.createAccount(request);
        } catch (UserRegistrationException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("the response is: " + response);
        assertEquals("Account Successfully Created", response.getMessage());

        UserLoginRequest loginRequest;
        UserLoginResponse loginResponse;
        loginRequest = UserLoginRequest.builder()
                .email("richardned@gmail.com")
                .password("P@ssw0rd")
                .build();
        loginResponse = userService.signIn(loginRequest);

        assertEquals("richardned@gmail.com", loginResponse.getEmail());

        assertEquals("Login successful", loginResponse.getMessage() );
        assertTrue(loginResponse.isLoggedIn());
    }

    @AfterEach void endAllTestWith(){
        userService.deleteAll();
    }

//    @Test
//    void userCanNotRegisterWithWrongPassword(){
//        final UserRegistrationResponse response; //= new UserRegistrationResponse();
////        UserRegistrationRequest request
//        UserRegistrationRequest request = UserRegistrationRequest.builder()
//                .name("John Malcom")
//                .EmailAddress("rich@gmail.com")
//                .password("1235")
//                .build();
//
//        assertThrows(UserRegistrationException.class, ()->response = userService.createAccount(request) );
//
//    }
//    @Test
//    void userCanNotRegisterWIthWrongEmail(){
//        request = UserRegistrationRequest.builder()
//                .name("John Malcom")
//                .EmailAddress("rich@mail.")
//                .password("hello")
//                .build();
//        userService = new HealthCareUserService();
//        assertThrows(UserRegistrationException.class, ()->response = userService.createAccount(request));
//
//    }


//    @Test
//    void loginTestCannotLogInWithWrongDetails() throws UserLoginException {
//        UserLoginRequest loginRequest;
//        UserLoginResponse loginResponse;
//        loginRequest = UserLoginRequest.builder()
//                .email("rich@mail.com")
//                .password("1235")
//                .build();
//        userService = new HealthCareUserService();
//        loginResponse = userService.signIn(loginRequest);
//
//        assertNotEquals("rich@gmail.com", loginResponse.getEmail());
//        assertNotEquals("1235", loginResponse.getPassword());
//
//        assertNotEquals("Logged In", loginResponse.getMessage() );
//        assertFalse(loginResponse.isLoggedIn());
//    }


}