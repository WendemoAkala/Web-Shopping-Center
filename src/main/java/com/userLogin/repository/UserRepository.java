package com.userLogin.repository;

import com.userLogin.model.CustomUser;

import java.util.List;

public interface UserRepository {
    void createUser(CustomUser customUser);
    List<CustomUser> getUsersByFirstName(String firstName);
    void deleteUserById(Long id);

    void updateUser(CustomUser customUser);

    CustomUser findByUsername(String username);
    CustomUser findUserById(Long id);

    CustomUser getUserByFirstName(String firstName);
}
