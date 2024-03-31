package com.userLogin.controller;

import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;
import com.userLogin.repository.UserRepository;
import com.userLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/public/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<?> createUser(@RequestBody CustomUserRequest customUser){
        try{
           userService.createUser(customUser);
           return null;
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
    @PutMapping("/update")
    @CrossOrigin
    public ResponseEntity<?> updateUser(@RequestBody CustomUserRequest customUser){
        try{
            userService.updateUser(customUser);
            return null;
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        try{
            userService.deleteUserById(id);
            return null;
        } catch (Exception exception){
           return   ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }

    }
    @GetMapping("/All/{firstName")
    @CrossOrigin
    public List<CustomUser> getUsersByFirstName(@PathVariable String firstName){
        userService.getUsersByFirstName(firstName);
        return null;
    }
    @GetMapping("/{firstName")
    @CrossOrigin
    public CustomUser getUserByFirstName(@PathVariable String firstName){
        userService.getUserByFirstName(firstName);
        return null;
    }
}



