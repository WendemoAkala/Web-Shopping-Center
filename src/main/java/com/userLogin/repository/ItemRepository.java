package com.userLogin.repository;

import com.userLogin.model.Item;

import java.util.List;

public interface ItemRepository {
    void createItem(Item item);
    Item findItemByTitle(String title);
    List<Item> findByTitleContaining(String title);
    List<Item> searchItemsByName(String title);
}
