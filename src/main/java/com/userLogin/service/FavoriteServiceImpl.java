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
//        Favorite existingFavorite = favoriteRepository.createFavorite(favoriteRequest.getUserId());
//        System.out.println(existingFavorite);
//        if(existingFavorite != null){
//            throw new Exception("Item " + favoriteRequest.getUserId() + " is already taken");
//        }
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
    public void delete(Favorite favorite) {

    }

    @Override
    public List<Favorite> findByCustomUser(CustomUser customUser) {
        return null;
    }

    @Override
    public List<Favorite> findByUserId(Long userId) {
        return null;
    }
}
