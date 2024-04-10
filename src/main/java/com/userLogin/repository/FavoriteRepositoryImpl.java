package com.userLogin.repository;

import com.userLogin.model.Favorite;
import com.userLogin.model.Item;
import com.userLogin.repository.mapper.FavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavoriteRepositoryImpl implements FavoriteRepository{
    private static final String FAVORITE_TABLE_NAME = "favorite";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void removeFromFavorites(List<Item> item) {
        String sql = "DELETE FROM " + FAVORITE_TABLE_NAME + " WHERE items?)";
        jdbcTemplate.update(sql, item);
    }

    @Override
    public void addToFavorites(Favorite favorite) {
        String sql = "INSERT INTO " + FAVORITE_TABLE_NAME + " (user_id,items) VALUES (?, ?)";
        jdbcTemplate.update(sql, favorite.getUserId(), favorite.getItem());
    }

    @Override
    public List<Favorite> getFavoriteListById(Long userId) {
        String sql = "SELECT * FROM " + FAVORITE_TABLE_NAME + " WHERE user_id=?";
       try{
           return jdbcTemplate.query(sql, new FavoriteMapper(), userId);
    } catch (EmptyResultDataAccessException error){
        System.out.println("Warning: EmptyResultDataAccessException");
        return null;
    }
    }

}
