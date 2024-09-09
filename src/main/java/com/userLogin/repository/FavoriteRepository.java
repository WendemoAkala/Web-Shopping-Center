package com.userLogin.repository;

import com.userLogin.model.Favorite;

import java.util.List;

public interface FavoriteRepository {
    void removeFromFavorites(Long userId);
    void addToFavorites(Favorite favorite);
    Favorite getFavoriteListById(Long userId);
}
