package com.userLogin.service;

import com.userLogin.model.Item;
import com.userLogin.model.ItemRequest;

import java.util.List;

public interface ItemService {
    void createItem(ItemRequest item) throws Exception;

    Item findItemByTitle(String title);

    List<Item> searchItemsByName(String title);

    Item findItemById(Long id);

    List<Item> findAll();

    void save(Item item);

    Item getAllItemsById(Long Id);

    Item getItemByTitle(String title);

    Item getItemById(Long id);
}
