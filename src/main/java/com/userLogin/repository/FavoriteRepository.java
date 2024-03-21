package com.userLogin.repository;

import com.userLogin.model.Favorite;

public interface FavoriteRepository {
    void createFavorite(Favorite favorite);
    void addToFavorites(Favorite favorite);
}
