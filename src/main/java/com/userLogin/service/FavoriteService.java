package com.userLogin.service;

import com.userLogin.model.*;

import java.util.Collection;
import java.util.List;

public interface FavoriteService {
    void addToFavorites(FavoriteRequest favorite) throws Exception;

    Collection<Object> findByUserAndItem(CustomUser customUser, Item item);

    Favorite save(Favorite favorite);

    void delete(Favorite favorite);

    List<Favorite> findByCustomUser(CustomUser customUser);
    List<Favorite> findByUserId(Long userId);
}
