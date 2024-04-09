package com.userLogin.repository;

import com.userLogin.model.Favorite;

import java.util.List;

public interface FavoriteRepository {
    void removeFromFavorites(Favorite favorite);
    void addToFavorites(Favorite favorite);
    List<Favorite> getFavoriteListById(Long id);
}
