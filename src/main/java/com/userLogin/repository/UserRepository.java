package com.userLogin.repository;

import com.userLogin.model.CustomUser;

public interface UserRepository {
    void createUser(CustomUser customUser);
    CustomUser findUserByUsername(String username);
    Long deleteUser(CustomUser customUser);
    Long updateUser(CustomUser customUser);

    Object findByUsername(String username);
}
