//package org.richards.healthcare.healthCareTest;
//
//import org.example.healthCare.dto.request.UserLoginRequest;
//import org.example.healthCare.dto.request.UserRegistrationRequest;
//import org.example.healthCare.dto.response.UserLoginResponse;
//import org.example.healthCare.dto.response.UserRegistrationResponse;
//import org.example.healthCare.exceptions.UserLoginException;
//import org.example.healthCare.exceptions.UserRegistrationException;
//import org.example.healthCare.service.HealthCareUserService;
//import org.example.healthCare.service.UserService;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.math.BigInteger;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//class UserServiceTest {
////    UserService userService = new HealthCareUserService();
////    UserRegistrationRequest request;
////    UserRegistrationResponse response;
//
////    @Test
//
////    void createAccountTestWithCorrectDetails() {
////        request = UserRegistrationRequest.builder()
////                .name("John Malcom")
////                .EmailAddress("richardned@gmail.com")
////                .password("P@ssw0rd")
////                .build();
////        userService = new HealthCareUserService();
////        try {
////            response = userService.createAccount(request);
////        } catch (UserRegistrationException e) {
////            System.out.println(e.getMessage());
////            e.printStackTrace();
////        }
////        System.out.println("the response is: " + response);
////        assertEquals("Account created Successfully", response.getMessage());
////        assertEquals(BigInteger.ONE.intValue(), userService.users().size());
////        System.out.println(userService.users().size());
////    }
//    @Test
//    void userCanNotRegisterWithWrongPassword(){
//        UserRegistrationRequest request = UserRegistrationRequest.builder()
//                .name("John Malcom")
//                .EmailAddress("rich@gmail.com")
//                .password("1235")
//                .build();
//        userService = new HealthCareUserService();
//       assertThrows(UserRegistrationException.class, ()->response = userService.createAccount(request) );
//
//    }
//    @Test
//    void userCanNotRegisterWIthWrongEmail(){
//        request = UserRegistrationRequest.builder()
//                .name("John Malcom")
//                .EmailAddress("richgmail.")
//                .password("Khfdjhj32'987ytgh")
//                .build();
//        userService = new HealthCareUserService();
//        assertThrows(UserRegistrationException.class, ()->response = userService.createAccount(request));
//
//    }
//
//
//    @Test
//    void loginTestCannotLogInWithWrongDetails() throws UserLoginException {
//        UserLoginRequest loginRequest;
//        UserLoginResponse loginResponse;
//        loginRequest = UserLoginRequest.builder()
//                .email("richgmail.com")
//                .password("1235")
//                .build();
//        userService = new HealthCareUserService();
//        loginResponse = userService.signIn(loginRequest);
//
//        assertNotEquals("rich@gmail.com", loginResponse.getEmail());
//        assertNotEquals("1235", loginResponse.getPassword());
//
//    assertNotEquals("Logged In", loginResponse.getMessage() );
//    assertFalse(loginResponse.isLoggedIn());
//    }
//    @Test
//    void loginTestUserCanLoginWithCorrectDetails() throws UserLoginException {
//        request = UserRegistrationRequest.builder()
//                .name("John Malcom")
//                .EmailAddress("richardned@gmail.com")
//                .password("P@ssw0rd")
//                .build();
//        userService = new HealthCareUserService();
//        try {
//            response = userService.createAccount(request);
//        } catch (UserRegistrationException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//
//        UserLoginRequest loginRequest;
//        UserLoginResponse loginResponse;
//        loginRequest = UserLoginRequest.builder()
//                .email("richardned@gmail.com")
//                .password("P@ssw0rd")
//                .build();
//        loginResponse = userService.signIn(loginRequest);
//
//        assertEquals("richardned@gmail.com", loginResponse.getEmail());
//
//        assertEquals("Logged In", loginResponse.getMessage() );
//        assertTrue(loginResponse.isLoggedIn());
//    }
//
//}