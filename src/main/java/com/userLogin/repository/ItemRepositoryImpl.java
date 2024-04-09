package com.userLogin.repository;

import com.userLogin.model.Item;
import com.userLogin.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository{
    private static final String ITEM_TABLE_NAME = "item";

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createItem(Item item) {
        String sql = "INSERT INTO " + ITEM_TABLE_NAME + " (title,photo_url, price, stock_count) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, item.getTitle(), item.getPhotoUrl(), item.getPrice(),
                item.getStockCount());
    }
    @Override
    public Item findItemByTitle(String title) {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME + " WHERE title=?";
        try {
            return jdbcTemplate.queryForObject(sql, itemMapper, title);
        } catch (EmptyResultDataAccessException error) {
            System.out.println("Warning: EmptyResultDataAccessException");
            return null;
        }
    }

    @Override
    public List<Item> findByTitleContaining(String title) {

        String sql = "SELECT * FROM " + ITEM_TABLE_NAME + " WHERE title=?";
        try {
            return jdbcTemplate.query(sql, itemMapper, title);
        } catch (EmptyResultDataAccessException error) {
            System.out.println("Warning: EmptyResultDataAccessException");
            return null;
        }
    }
    @Override
    public List<Item> searchItemsByName(String title) {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME + " WHERE title=?";
        try {
            return jdbcTemplate.query(sql, itemMapper, title);
        } catch (EmptyResultDataAccessException error) {
            System.out.println("Warning: EmptyResultDataAccessException");
            return null;
        }
    }
}
