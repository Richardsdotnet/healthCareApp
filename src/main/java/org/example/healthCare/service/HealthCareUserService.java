package org.example.healthCare.service;

import org.example.healthCare.dto.request.UserLoginRequest;
import org.example.healthCare.dto.request.UserRegistrationRequest;
import org.example.healthCare.dto.response.UserLoginResponse;
import org.example.healthCare.dto.response.UserRegistrationResponse;
import org.example.healthCare.exceptions.UserLoginException;
import org.example.healthCare.exceptions.UserRegistrationException;
import org.example.healthCare.models.User;
import org.example.healthCare.repository.HealthCareUserRepository;
import org.example.healthCare.repository.UserRepository;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HealthCareUserService implements UserService{
    UserRepository userRepository = new HealthCareUserRepository();
    @Override
    public UserRegistrationResponse createAccount(UserRegistrationRequest userRegistrationRequest) throws UserRegistrationException {
        boolean isValidPassword = validatePassword(userRegistrationRequest.getPassword());
        boolean isValidEmail = validatEmail(userRegistrationRequest.getEmailAddress());
            UserRegistrationResponse userRegistrationResponse = new UserRegistrationResponse();
        if(isValidPassword && isValidEmail) {

            User user1 = User.builder()
                    .emailAddress(userRegistrationRequest.getEmailAddress())
                    .name(userRegistrationRequest.getName())
                    .password(userRegistrationRequest.getPassword()).build();
            userRepository.save(user1);

            userRegistrationResponse.setMessage("Account created Successfully");

        }else{
            throw new UserRegistrationException("wrong Email or password");
        }
        return userRegistrationResponse;
    }

    @Override
    public UserLoginResponse signIn(UserLoginRequest userLoginRequest) throws UserLoginException {
        boolean isValidEmail = validatEmail(userLoginRequest.getEmail());
            UserLoginResponse userLoginResponse = new UserLoginResponse();
        if (isValidEmail) {

            User returningUser = User.builder()
                    .emailAddress(userLoginRequest.getEmail())
                    .password(userLoginRequest.getPassword())
                    .build();
            for (User user : userRepository.findAll()) {
                if (user.getEmailAddress().equals(returningUser.getEmailAddress()) && user.getPassword().equals(returningUser.getPassword())) {
                    userLoginResponse.setMessage("Logged In");
                    userLoginResponse.setEmail(returningUser.getEmailAddress());
                    userLoginResponse.setUserName(user.getName());
                    userLoginResponse.setLoggedIn(true);
                }
            }
        }


//        if (userLoginRequest.getPassword().equals(user2.getPassword())) {
//            UserLoginResponse userLoginResponse = new UserLoginResponse();
//            userLoginResponse.setMessage("Logged in");
//            return userLoginResponse;
//        }
        return userLoginResponse;
//        throw new UserLoginException("Login Failed:: Reason you have either entered a wrong username or password");


    }
    private boolean validatePassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
//        Pattern p = Pattern.compile("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$");
//        Matcher m = p.matcher(password);
//        return m.matches();
    }
    private boolean validatEmail(String email) {
//        Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");
        Pattern p = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Matcher m = p.matcher(email);


        return m.matches();
    }

    @Override
    public List<User> users() {
        return userRepository.findAll();
    }


}
