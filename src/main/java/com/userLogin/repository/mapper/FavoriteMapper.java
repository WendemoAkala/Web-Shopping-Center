package com.userLogin.repository.mapper;

import com.userLogin.model.Favorite;
import com.userLogin.model.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FavoriteMapper implements RowMapper<Favorite> {
    @Override
    public Favorite mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Favorite(
                rs.getLong("id"),
                rs.getLong("user_id"),
                (List<Item>) rs.getObject("items")

        );
    }
}
