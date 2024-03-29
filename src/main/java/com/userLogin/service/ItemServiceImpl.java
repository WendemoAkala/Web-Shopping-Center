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
    public void createItem(ItemRequest item) {
        itemRepository.createItem(item.toItem());
    }

    @Override
    public Item findItemByTitle(String title) {
        return itemRepository.findItemByTitle(title);
    }

    @Override
    public List<Item> searchItemsByName(String title) {
        itemRepository.searchItemsByName(title);
        return null;
    }

    @Override
    public Optional<Object> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public void save(Item item) {

    }
}
