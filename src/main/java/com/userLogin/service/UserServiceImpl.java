package com.userLogin.service;

import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;
import com.userLogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(CustomUserRequest customUserRequest) throws Exception {
        CustomUser existingCustomUser = userRepository.findUserByUsername(customUserRequest.getUsername());
        if(existingCustomUser != null){
            throw new Exception("Username " + customUserRequest.getUsername() + " is already taken");
        }
        userRepository.createUser(customUserRequest.toCustomUser());
    }

    @Override
    public void updateUser(CustomUserRequest customUser) {

    }

    @Override
    public CustomUser findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public Long deleteUser(CustomUser customUser) throws Exception {
        CustomUser existingCustomUser = (CustomUser) userRepository.findByUsername(customUser.getUsername());
        if(existingCustomUser != null){
            throw new Exception("Username " + customUser.getUsername() + " is already taken");
        }
        userRepository.deleteUser(customUser);
        return null;
    }

    @Override
    public Optional<Object> findById(Long userId) {
        return Optional.empty();
    }
}





