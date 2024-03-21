package com.userLogin.repository;

import com.userLogin.model.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FavoriteRepositoryImpl implements FavoriteRepository{
    private static final String FAVORITE_TABLE_NAME = "favorite";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createFavorite(Favorite favorite) {
        String sql = "INSERT INTO " + FAVORITE_TABLE_NAME + " (user_id, items) VALUES (?, ?)";
        jdbcTemplate.update(sql,favorite.getUserId(),favorite.getItem() );
    }

    @Override
    public void addToFavorites(Favorite favorite) {
        String sql = "INSERT INTO " + FAVORITE_TABLE_NAME + " (user_id,items) VALUES (?, ?)";
        jdbcTemplate.update(sql, favorite.getUserId(), favorite.getItem());
    }

}
