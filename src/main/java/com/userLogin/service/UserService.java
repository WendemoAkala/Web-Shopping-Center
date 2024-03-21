package com.userLogin.service;

import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;

import java.util.Optional;

public interface UserService {
    void createUser(CustomUserRequest customUser) throws Exception;
    void updateUser(CustomUserRequest customUser);

    CustomUser findUserByUsername(String username);
    Long deleteUser(CustomUser customUser) throws Exception;

    Optional<Object> findById(Long userId);
}
