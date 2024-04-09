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
    @Override
    public void addToFavorites(FavoriteRequest favoriteRequest) throws Exception {
        List<Favorite> existingFavorite = favoriteRepository.getFavoriteListById(favoriteRequest.getUserId());
        if(existingFavorite != null){
            throw new Exception("Item " + favoriteRequest.getUserId() + " is already taken");
        }
            favoriteRepository.addToFavorites(favoriteRequest.toFavorite());

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
    public void removeFromFavorites(Favorite favorite) {
        favoriteRepository.removeFromFavorites(favorite);
    }

    @Override
    public List<Favorite> findByCustomUser(CustomUser customUser) {
        return favoriteRepository.getFavoriteListById(customUser.getId());
    }

    @Override
    public List<Favorite> findByUserId(Long userId) {
        return favoriteRepository.getFavoriteListById(userId);
    }
}
