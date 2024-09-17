package com.userLogin.controller;

import com.userLogin.model.*;
import com.userLogin.service.FavoriteService;
import com.userLogin.service.ItemService;
import com.userLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class FavoriteController {
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private FavoriteService favoriteService;
    @PostMapping("/favorites/add")
    @CrossOrigin
    public void addToFavorites(@RequestBody FavoriteRequest favoriteRequest) throws Exception {

        favoriteService.addToFavorites(favoriteRequest);
//        favoriteRequest.setItem(favoriteService.getItemById(id));
    }

    @DeleteMapping(value = "/favorites/remove/{id}")
    @CrossOrigin
    public void removeFromFavorites(@PathVariable Long id) {
        favoriteService.removeFromFavorites(id);
            }

    @GetMapping(value = "/favorites/user/{userId}")
    @CrossOrigin
    public CustomUser getUserFavorites(@PathVariable Long userId) {
       return   userService.getUserById(userId);
    }

    @GetMapping(value = "/favorites/item/{itemId}")
    @CrossOrigin
    public Item getFavoriteItem(@PathVariable Long itemId) {
        return itemService.getItemById(itemId);
    }
}
