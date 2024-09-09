package com.userLogin.service;

import com.userLogin.model.CustomUser;
import com.userLogin.model.Favorite;
import com.userLogin.model.FavoriteRequest;
import com.userLogin.model.Item;
import com.userLogin.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService{
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private  ItemService itemService;
    @Override
    public void addToFavorites(FavoriteRequest favorite) throws Exception {
        Favorite existingFavorite = favoriteRepository.getFavoriteListById(favorite.getUserId());
        if(existingFavorite != null){
            throw new Exception("Item " + favorite.getUserId() + " is already taken");
        }
            favoriteRepository.addToFavorites(favorite.toFavorite());

    }

    @Override
    public Collection<Object> findByUserAndItem(CustomUser customUser, Item item) {
        return null;
    }

    @Override
    public Favorite save(Favorite favorite) {
        return null;
    }

    @Override
    public void removeFromFavorites(Long userId) {
        favoriteRepository.removeFromFavorites(userId);
    }

    @Override
    public Favorite findByCustomUser(CustomUser customUser) {
        return favoriteRepository.getFavoriteListById(customUser.getId());
    }

    @Override
    public Favorite findByUserId(Long userId) {
        return favoriteRepository.getFavoriteListById(userId);
    }
}
