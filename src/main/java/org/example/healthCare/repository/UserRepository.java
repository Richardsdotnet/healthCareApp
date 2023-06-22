package org.example.healthCare.repository;

import org.example.healthCare.models.User;

import java.util.List;

public interface UserRepository{

    int length();
    void save(User user);
    List<User> findAll();
    User findUserByUserName(String userName);

    User findUserById(String id);

    boolean deleteUserById(String UserId);
}
