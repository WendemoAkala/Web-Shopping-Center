package com.userLogin.service;

import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;
import com.userLogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(CustomUserRequest customUserRequest) throws Exception {
        CustomUser existingCustomUser = userRepository.findUserById(customUserRequest.getId());
        if(existingCustomUser != null){
            throw new Exception("Id " + customUserRequest.getId() + " is already taken");
        }
        userRepository.createUser(customUserRequest.toCustomUser());
    }

    @Override
    public void updateUser(CustomUserRequest customUserRequest) {

    }

    @Override
    public List<CustomUser> getUsersByFirstName(String firstName) {
         userRepository.getUsersByFirstName(firstName);
         return null;
    }
    @Override
    public CustomUser getUserByFirstName(String firstName) {
        userRepository.getUserByFirstName(firstName);
        return null;
    }
    @Override
    public CustomUser findByUsername(String username) {
        userRepository.findByUsername(username);
        return null;
    }

    @Override
    public Optional<Object> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteUserById(Long id) {
//        CustomUser existingCustomUser = userRepository.findUserById(id);
        try{
            userRepository.deleteUserById(id);
        }catch (EnumConstantNotPresentException e){
            System.out.println("user not found");
        }
    }
}
