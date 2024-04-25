package com.userLogin.repository;

import com.userLogin.model.Favorite;
import com.userLogin.model.Item;

import java.util.List;

public interface FavoriteRepository {
    void removeFromFavorites(Long userId);
    void addToFavorites(Favorite favorite);
    List<Favorite> getFavoriteListById(Long userId);
}
