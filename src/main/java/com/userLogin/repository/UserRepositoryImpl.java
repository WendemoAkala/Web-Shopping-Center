package com.userLogin.repository;

import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;
import com.userLogin.model.Favorite;
import com.userLogin.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String USER_TABLE_NAME = "user";

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(CustomUser customUser) {
        String sql = "INSERT INTO " + USER_TABLE_NAME + " (first_name, last_name, email, phone, address,username, password, roles, permissions) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, customUser.getFirstName(), customUser.getLastName(), customUser.getEmail(), customUser.getPhone(),
                            customUser.getAddress(), customUser.getUsername(), customUser.getPassword(), customUser.getRoles(), customUser.getPermissions());
        System.out.println("created user from UI");
    }

    @Override
    public List<CustomUser> getUsersByFirstName(String firstName) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE first_name=?";
        try {
            return jdbcTemplate.query(sql, userMapper, firstName);
        } catch (EmptyResultDataAccessException error) {
            System.out.println("Warning: EmptyResultDataAccessException");
            return null;
        }
    }
    @Override
    public CustomUser getUserByFirstName(String firstName) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE first_name=?";
        try {
            return jdbcTemplate.queryForObject(sql, userMapper, firstName);
        } catch (EmptyResultDataAccessException error) {
            System.out.println("Warning: EmptyResultDataAccessException");
            return null;
        }
    }

    @Override
    public List<CustomUser> getAllUsers() {
        String sql = "SELECT * FROM " + USER_TABLE_NAME ;
        try {
            return jdbcTemplate.query(sql, userMapper);
        } catch (EmptyResultDataAccessException error) {
            System.out.println("Warning: EmptyResultDataAccessException");
            return null;
        }
    }

    @Override
    public CustomUser getUserById(Long id) {

        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, userMapper, id);
        } catch (EmptyResultDataAccessException error) {
            System.out.println("Warning: EmptyResultDataAccessException");
            return null;
        }
    }

    @Override
    public void deleteUserById(Long id) {
            String sql = "DELETE FROM " + USER_TABLE_NAME + " WHERE id=?";
            jdbcTemplate.update(sql , id);

    }
    @Override
    public void updateUser(CustomUser customUser){
        String sql = "UPDATE " + USER_TABLE_NAME + " SET first_name=?, last_name=?, email=?, phone=?, address=?, username=?, password=?  WHERE id=?";
            jdbcTemplate.update(sql, customUser.getFirstName(), customUser.getLastName(), customUser.getEmail(), customUser.getPhone(),
                    customUser.getAddress(), customUser.getUsername(), customUser.getPassword(),customUser.getId());
    }

    @Override
    public CustomUser findByUsername(String username) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE username=?";
        try {
            return jdbcTemplate.queryForObject(sql,userMapper, username);
        } catch (EmptyResultDataAccessException error) {
            System.out.println("Warning: EmptyResultDataAccessException");
            return null;
        }
    }

    @Override
    public CustomUser findUserById(Long id) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, userMapper, id);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

}



