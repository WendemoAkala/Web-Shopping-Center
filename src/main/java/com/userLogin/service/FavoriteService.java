package com.userLogin.service;

import com.userLogin.model.*;

import java.util.Collection;
import java.util.List;

public interface FavoriteService {
    void addToFavorites(FavoriteRequest favorite) throws Exception;

    Collection<Object> findByUserAndItem(CustomUser customUser, Item item);

    Favorite save(Favorite favorite);

    void removeFromFavorites(Long userId);

    Favorite findByCustomUser(CustomUser customUser);
    Favorite findByUserId(Long userId);
}
