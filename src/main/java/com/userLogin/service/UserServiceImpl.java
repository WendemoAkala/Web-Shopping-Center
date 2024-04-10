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
    public void updateUser(CustomUserRequest customUserRequest) throws Exception{
        CustomUser existingCustomUser = userRepository.getUserByFirstName(customUserRequest.getFirstName());
        if (existingCustomUser == null) {
            throw new Exception("User whit firstname " + customUserRequest.getFirstName() + " is not exist create new user");
        }
        existingCustomUser.setFirstName(customUserRequest.getFirstName());
        existingCustomUser.setLastName(customUserRequest.getLastName());
        existingCustomUser.setEmail(customUserRequest.getEmail());
        existingCustomUser.setPhone(customUserRequest.getPhone());
        existingCustomUser.setAddress(customUserRequest.getAddress());
        existingCustomUser.setUsername(customUserRequest.getUsername());
        existingCustomUser.setPassword(customUserRequest.getPassword());
        userRepository.updateUser(existingCustomUser);
    }

    @Override
    public List<CustomUser> getUsersByFirstName(String firstName) {
//        List<CustomUser> existingCustomUser = userRepository.getUsersByFirstName(firstName);
        return userRepository.getUsersByFirstName(firstName);
//         return null;
    }

    @Override
    public CustomUser getUserByFirstName(String firstName) {
//        CustomUser existingCustomUser = userRepository.getUserByFirstName(firstName);
        return userRepository.getUserByFirstName(firstName);
//        return null;
    }

    @Override
    public CustomUser save(CustomUser customUser) {
        CustomUser existingCustomUser = userRepository.getUserByFirstName(customUser.getFirstName());
         userRepository.updateUser(existingCustomUser);
        return save(existingCustomUser);
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
    public Optional<Object> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteUserById(Long id) {
//       List<CustomUser> existingCustomUser = userRepository.getAllUsers();
                userRepository.deleteUserById(id);
               System.out.println("user whit id " + id + " is deleted");
    }
}
