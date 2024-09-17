package com.userLogin.service;

import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;
import com.userLogin.model.Favorite;
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
    public void updateUser(CustomUser customUser){
         userRepository.updateUser(customUser);
    }



    @Override
    public List<CustomUser> getUsersByFirstName(String firstName) {
        return userRepository.getUsersByFirstName(firstName);
    }

    @Override
    public CustomUser getUserByFirstName(String firstName) {
        return userRepository.getUserByFirstName(firstName);
    }

    @Override
    public CustomUser getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public CustomUser save(CustomUser customUser) {
        return save(customUser);
    }

    @Override
    public List<CustomUser> getAllUsers() {
       return userRepository.getAllUsers();

    }

    @Override
    public CustomUser findByUsername(String username) {
//        CustomUser existingCustomUser = userRepository.findByUsername(username);
        return  userRepository.findByUsername(username);
    }

    @Override
    public void deleteUserById(Long id) {
                userRepository.deleteUserById(id);
               System.out.println("user whit id " + id + " is deleted");
    }
}
