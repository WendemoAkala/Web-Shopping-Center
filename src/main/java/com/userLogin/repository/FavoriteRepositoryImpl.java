package com.userLogin.repository;

import com.userLogin.model.Favorite;
import com.userLogin.repository.mapper.FavoriteMapper;
import com.userLogin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavoriteRepositoryImpl implements FavoriteRepository{
    private static final String FAVORITE_TABLE_NAME = "favorite";
    @Autowired
    private ItemService itemService;
    @Autowired
    private FavoriteMapper favoriteMapper;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void removeFromFavorites(Long userId) {
        String sql = "DELETE FROM " + FAVORITE_TABLE_NAME + " WHERE user_id=?";
        jdbcTemplate.update(sql, favoriteMapper, userId);
    }

    @Override
    public void addToFavorites(Favorite favorite) {
        String sql = "INSERT INTO " + FAVORITE_TABLE_NAME + " (user_id,items) VALUES (?, ?)";
        jdbcTemplate.update(sql, favorite.getUserId(), favorite.getItem());
    }

    @Override
    public Favorite getFavoriteListById(Long userId) {
        String sql = "SELECT * FROM " + FAVORITE_TABLE_NAME + " WHERE user_id=?";
       try{
           return jdbcTemplate.queryForObject(sql, favoriteMapper, userId);
    } catch (EmptyResultDataAccessException error){
        System.out.println("Warning: EmptyResultDataAccessException");
        return null;
    }
    }

}
