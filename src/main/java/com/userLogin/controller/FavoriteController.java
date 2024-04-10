package com.userLogin.controller;

import com.userLogin.model.Favorite;
import com.userLogin.model.FavoriteRequest;
import com.userLogin.model.Item;
import com.userLogin.repository.mapper.FavoriteMapper;
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
    public ResponseEntity<?> addToFavorites(@RequestBody FavoriteRequest favoriteRequest){
        try{
        favoriteService.addToFavorites(favoriteRequest);
        return null;
    } catch (Exception exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    }

    @DeleteMapping("/remove")
    @CrossOrigin
    public void removeFromFavorites(@PathVariable Long userId) {
                favoriteService.removeFromFavorites(userId);
            }

    @GetMapping(value = "/user/{userId}")
    @CrossOrigin
    public List<Favorite> getUserFavorites(@PathVariable Long userId) {
       return   favoriteService.findByUserId(userId);
    }
}
