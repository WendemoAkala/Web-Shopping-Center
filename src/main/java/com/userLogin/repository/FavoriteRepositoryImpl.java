package com.userLogin.repository;

import com.userLogin.model.Favorite;
import com.userLogin.model.Item;
import com.userLogin.repository.mapper.FavoriteMapper;
import com.userLogin.repository.mapper.ItemMapper;
import com.userLogin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class FavoriteRepositoryImpl implements FavoriteRepository{
    private static final String FAVORITE_TABLE_NAME = "favorite";
    private static final String ITEM_TABLE_NAME = "item";
    @Autowired
    private ItemService itemService;
    @Autowired
    private FavoriteMapper favoriteMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void removeFromFavorites(Long id) {
        String sql = "DELETE FROM " + FAVORITE_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void addToFavorites(Favorite favorite) {
        String sql = "INSERT INTO " + FAVORITE_TABLE_NAME + " (user_id,item_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, favorite.getUserId(), favorite.getItemId());
    }

    @Override
    public Favorite getFavoriteById(Long userId) {
        String sql = "SELECT * FROM " + FAVORITE_TABLE_NAME + " WHERE user_id=?";
       try{
           return jdbcTemplate.queryForObject(sql, favoriteMapper, userId);
    } catch (EmptyResultDataAccessException error){
        System.out.println("Warning: EmptyResultDataAccessException");
        return null;
    }
    }

    @Override
    public Item getItemById(Long itemId) {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME + " WHERE item_id=?";
        try{
            return jdbcTemplate.queryForObject(sql, itemMapper, itemId);
        } catch (EmptyResultDataAccessException error){
            System.out.println("Warning: EmptyResultDataAccessException");
            return null;
        }
    }

}
