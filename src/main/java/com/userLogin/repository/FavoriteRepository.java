package com.userLogin.repository;

import com.userLogin.model.Favorite;
import com.userLogin.model.Item;

import java.util.List;

public interface FavoriteRepository {
    void removeFromFavorites(Long id);
    void addToFavorites(Favorite favorite);
    Favorite getFavoriteById(Long userId);

    Item getItemById(Long itemId);
}
