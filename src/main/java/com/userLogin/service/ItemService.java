package com.userLogin.service;

import com.userLogin.model.Item;
import com.userLogin.model.ItemRequest;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    void createItem(ItemRequest item) throws Exception;

    Item findItemByTitle(String title);

    List<Item> searchItemsByName(String title);

    Optional<Object> findById(Long id);

    List<Item> findAll();

    void save(Item item);

    List<Item> getAllItemsByUserId(Long userId);

    Item getItemByTitle(String title);
}
