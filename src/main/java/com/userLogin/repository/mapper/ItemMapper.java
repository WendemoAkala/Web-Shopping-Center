package com.userLogin.repository.mapper;

import com.userLogin.model.Item;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class ItemMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Item(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("photo_url"),
                rs.getDouble("price"),
                rs.getInt("stock_count")

        );
    }

}
