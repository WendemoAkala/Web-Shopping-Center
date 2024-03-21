package com.userLogin.controller;
import com.userLogin.model.Item;
import com.userLogin.model.ItemRequest;
import com.userLogin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/public/items")
public class ItemController {
    @Autowired
    private ItemService itemService;


    @GetMapping("/all")
    @CrossOrigin
    public List<Item> getAllItems() {
        return itemService.findAll();
    }
    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<?> createItem(@RequestBody ItemRequest item) {
        try{
            itemService.createItem(item);
            return null;
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
    @GetMapping("/search")
    @CrossOrigin
    public ResponseEntity<List<Item>> searchItemsByName(@RequestParam String title) {
        List<Item> searchResults = itemService.searchItemsByName(title);
        if (searchResults.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(searchResults);
        }
    }

}
