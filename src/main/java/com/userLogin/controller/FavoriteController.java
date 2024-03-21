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
    public ResponseEntity<?> addToFavorites(@RequestBody FavoriteRequest favoriteRequest) throws Exception {
        try{
        favoriteService.addToFavorites(favoriteRequest);
        return null;
    } catch (Exception exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    }

    @DeleteMapping("/remove")
    @CrossOrigin
    public void removeFromFavorites(@RequestParam Long userId, @RequestParam Long id) {
        CustomUser customUser = (CustomUser) userService.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Item item = (Item) itemService.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));

       Collection<Object> favorites = favoriteService.findByUserAndItem(customUser, item);

        if (!favorites.isEmpty()) {
            for (Object favorite : favorites) {
                favoriteService.delete((Favorite) favorite);
            }
        }
    }

    @GetMapping("/user/{userId}")
    @CrossOrigin
    public List<List<Item>> getUserFavorites(@PathVariable Long userId) {
        CustomUser customUser = (CustomUser) userService.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        List<Favorite> favorites = favoriteService.findByCustomUser(customUser);
        return favorites.stream().map(Favorite::getItem).collect(Collectors.toList());
    }

}
