package com.userLogin.service;

import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(CustomUserRequest customUser) throws Exception;
    void updateUser(CustomUserRequest customUserRequest);

    List<CustomUser> getUsersByFirstName(String firstName);

    Optional<Object> findById(Long id);
    CustomUser findByUsername(String username);

    void deleteUserById(Long id);

    CustomUser getUserByFirstName(String firstName);
}
