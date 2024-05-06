package com.userLogin.repository;

import com.userLogin.model.Item;

import java.util.List;

public interface ItemRepository {
    void createItem(Item item);
    Item findItemByTitle(String title);
    List<Item> findByTitleContaining(String title);
//    List<Item> searchItemsByName(String title);

    List<Item> findAll();

    List<Item> getAllItemsByUserId(Long userId);

    Item getItemByTitle(String title);

    List<Item> searchItemsByTitle(String title);
}
