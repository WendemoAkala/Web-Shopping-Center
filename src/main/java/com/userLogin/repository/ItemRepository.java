package com.userLogin.repository;

import com.userLogin.model.Item;

import java.util.List;

public interface ItemRepository {
    void createItem(Item item);
    Item findItemByTitle(String title);

    Item findItemById(Long id);

    List<Item> findByTitleContaining(String title);
//    List<Item> searchItemsByName(String title);

    List<Item> findAll();

    Item getAllItemsById(Long id);

    Item getItemByTitle(String title);

    List<Item> searchItemsByTitle(String title);

    Item getItemById(Long id);

    void save(Item item1);
}
