package com.userLogin.controller;
import com.userLogin.model.Item;
import com.userLogin.model.ItemRequest;
import com.userLogin.model.Order;
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


    @GetMapping("/all/")
    @CrossOrigin
    public List<Item> getAllItems() {
       return itemService.findAll();
    }
    @PostMapping(value = "/create")
    @CrossOrigin
    public void createItem(@RequestBody ItemRequest item) throws Exception {
        itemService.createItem(item);
    }
    @GetMapping("/search/")
    @CrossOrigin
    public List<Item> searchItemsByName(@RequestParam String title) {
         return itemService.searchItemsByName(title);
    }

}
