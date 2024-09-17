package com.userLogin.service;

import com.userLogin.model.Item;
import com.userLogin.model.ItemRequest;
import com.userLogin.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public void createItem(ItemRequest itemRequest) throws Exception {

        itemRepository.createItem(itemRequest.toItem());
    }

    @Override
    public Item findItemByTitle(String title) {
        return itemRepository.findItemByTitle(title);
    }

    @Override
    public List<Item> searchItemsByName(String title) {
       return itemRepository.searchItemsByTitle(title);
    }

    @Override
    public Item findItemById(Long id) {
        return itemRepository.findItemById(id);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public void save(Item item) {

    }

    @Override
    public Item getAllItemsById(Long id) {
        return itemRepository.getAllItemsById(id);
    }

    @Override
    public Item getItemByTitle(String title) {
        return itemRepository.getItemByTitle(title);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.getItemById(id);
    }
}
