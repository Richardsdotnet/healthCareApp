package org.example.healthCare.repository;

import org.example.healthCare.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HealthCareUserRepository implements UserRepository{

    List<User>users = new ArrayList<>();

    @Override
    public int length() {
        return users.size();
    }

    @Override
    public void save(User user) {
        if (isNotExisting(user))
            saveNew(user);
    }

    private User existing(User user) {
        return user;
    }

    private void saveNew(User user) {
        user.setId(String.valueOf(UUID.randomUUID()));
        users.add(user);
    }

    private boolean isNotExisting(User user) {
        return user.getId() == null || !users.contains(user);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findUserByUserName(String userName) {
        return null;
    }

    @Override
    public User findUserById(String id) {
        for (User admin:users)
            if(admin.getId().equals(id)) return admin;
        return null;
    }


    @Override
    public boolean deleteUserById(String userId) {
        User foundUser = findUserById(userId);
        if(foundUser != null) {
            users.remove(foundUser);
            return true;
        }
        return false;
    }



}
