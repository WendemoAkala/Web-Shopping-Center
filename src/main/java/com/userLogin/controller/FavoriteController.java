package com.userLogin.controller;

import com.userLogin.model.Favorite;
import com.userLogin.model.FavoriteRequest;
import com.userLogin.service.FavoriteService;
import com.userLogin.service.ItemService;
import com.userLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/favorites")
public class FavoriteController {
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private FavoriteService favoriteService;
    @PostMapping("/add")
    @CrossOrigin
    public void addToFavorites(@RequestBody FavoriteRequest favoriteRequest) throws Exception {

             favoriteService.addToFavorites(favoriteRequest);
    }

    @DeleteMapping(value = "/remove/{userId}")
    @CrossOrigin
    public void removeFromFavorites(@PathVariable Long userId) {
                favoriteService.removeFromFavorites(userId);
            }

    @GetMapping(value = "/user/{userId}")
    @CrossOrigin
    public Favorite getUserFavorites(@PathVariable Long userId) {
       return   favoriteService.findByUserId(userId);
    }
}
