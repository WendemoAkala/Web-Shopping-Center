package com.userLogin.service;

import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;
import com.userLogin.model.Favorite;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(CustomUserRequest customUser) throws Exception;
    void updateUser(CustomUser customUser) throws Exception;

    List<CustomUser> getUsersByFirstName(String firstName);

    Optional<Object> findById(Long id);
    CustomUser findByUsername(String username);

    void deleteUserById(Long id);

    CustomUser getUserByFirstName(String firstName);
    CustomUser save(CustomUser customUser);

    List<CustomUser> getAllUsers();
}
