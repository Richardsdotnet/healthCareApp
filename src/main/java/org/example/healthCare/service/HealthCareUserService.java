package org.example.healthCare.service;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import lombok.RequiredArgsConstructor;
import org.example.healthCare.dto.request.UserLoginRequest;
import org.example.healthCare.dto.request.UserRegistrationRequest;
import org.example.healthCare.dto.response.UserLoginResponse;
import org.example.healthCare.dto.response.UserRegistrationResponse;
import org.example.healthCare.exceptions.UserLoginException;
import org.example.healthCare.exceptions.UserRegistrationException;
import org.example.healthCare.models.User;
import org.example.healthCare.repository.UserRepository;
import org.example.healthCare.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Slf4j
@Service
@RequiredArgsConstructor

public class HealthCareUserService implements UserService{
    private final UserRepository userRepository;
    @Override
    public UserRegistrationResponse createAccount(UserRegistrationRequest userRegistrationRequest) throws UserRegistrationException {
       // userRepository.deleteAll();
        User user1 = Mapper.map(userRegistrationRequest);
        User savedUser = userRepository.save(user1);
        return Mapper.map(savedUser);
    }



    @Override
    public UserLoginResponse signIn(UserLoginRequest userLoginRequest) throws UserLoginException {
        // boolean isValidEmail = validateEmail(userLoginRequest.getEmail());
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        boolean isFoundUser = false;
        ModelMapper modelMapper = new ModelMapper();
        User user1 = Mapper.map(userLoginRequest);

        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(user1.getEmail()) && user.getPassword().equals(user1.getPassword())) {
                userLoginResponse = modelMapper.map(user, UserLoginResponse.class);
                userLoginResponse.setLoggedIn(true);
                userLoginResponse.setMessage("Login successful");
                isFoundUser = true;
                break;
            }

        }
        if(!isFoundUser){
            userLoginResponse.setLoggedIn(false);
            userLoginResponse.setMessage("Incorrect username or password");
            }
           return userLoginResponse;
        }

    private boolean validatePassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private boolean validateEmail(String email) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    @Override
    public List<User> users() {
        return userRepository.findAll();
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

}
