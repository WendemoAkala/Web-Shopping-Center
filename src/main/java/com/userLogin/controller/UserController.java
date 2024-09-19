package com.userLogin.controller;

import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;
import com.userLogin.repository.UserRepository;
import com.userLogin.service.FavoriteService;
import com.userLogin.service.OrderService;
import com.userLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("api/public/user")
public class UserController {

    @Autowired
    private UserService userService;
    private OrderService orderService;
    private FavoriteService favoriteService;

    @PostMapping(value = "/create")
    @CrossOrigin
    public void createUser(@RequestBody CustomUserRequest customUser) throws Exception {
          userService.createUser(customUser);
    }
    @PutMapping(value = "/update")
    @CrossOrigin
    public void updateUser(@RequestBody CustomUser customUser) throws Exception {
             userService.updateUser(customUser);
    }

    @DeleteMapping(value = "/delete/{id}")
    @CrossOrigin
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }
    @GetMapping(value = "/All/")
    @CrossOrigin
    public List<CustomUser> getUsersByFirstName(@RequestParam String firstName){
        return userService.getUsersByFirstName(firstName);
    }
    @GetMapping(value = "/getUserByFirstName/")
    @CrossOrigin
    public CustomUser getUserByFirstName(@RequestParam String firstName){
        return userService.getUserByFirstName(firstName);
    }
    @GetMapping(value = "/getUserById/{id}")
    @CrossOrigin
    public CustomUser getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @GetMapping(value = "/all/")
    @CrossOrigin
    public List<CustomUser> getAllUsers(){
       return userService.getAllUsers();
    }

}



