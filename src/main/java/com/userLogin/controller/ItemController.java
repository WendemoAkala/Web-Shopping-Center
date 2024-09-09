package com.userLogin.controller;
import com.userLogin.model.Item;
import com.userLogin.model.ItemRequest;
import com.userLogin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/all/{id}")
    @CrossOrigin
    public Item getAllItemsById(@PathVariable Long id) {
        return itemService.getAllItemsById(id);
    }

    @GetMapping("/item/{title}")
    @CrossOrigin
    public Item getItemByTitle(@PathVariable String title) {
        return itemService.getItemByTitle(title);
    }
    @GetMapping("/item/{id}")
    @CrossOrigin
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }
    @PostMapping(value = "/create")
    @CrossOrigin
    public void createItem(@RequestBody ItemRequest itemRequests) throws Exception {
        itemService.createItem( itemRequests);

    }
    @GetMapping("/search/")
    @CrossOrigin
    public List<Item> searchItemsByName(@RequestParam String title) {
         return itemService.searchItemsByName(title);
    }

}
