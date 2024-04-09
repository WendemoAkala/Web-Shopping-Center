package com.userLogin.controller;

import com.userLogin.model.CustomUser;
import com.userLogin.model.Favorite;
import com.userLogin.model.FavoriteRequest;
import com.userLogin.model.Item;
import com.userLogin.service.FavoriteService;
import com.userLogin.service.ItemService;
import com.userLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
    public void removeFromFavorites(@RequestParam Long userId) {
                favoriteService.removeFromFavorites((Favorite) getUserFavorites(userId));
            }

    @GetMapping(value = "/user/{userId}")
    @CrossOrigin
    public List<List<Item>> getUserFavorites(@PathVariable Long userId) {
         favoriteService.findByUserId(userId);
         return null;
    }
}
