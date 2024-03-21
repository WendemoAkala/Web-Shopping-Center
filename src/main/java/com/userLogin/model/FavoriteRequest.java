package com.userLogin.model;

import java.util.List;

public class FavoriteRequest {
    private Long id;
    private Long userId;
    private List<Item> item;

    public FavoriteRequest(Long id, Long userId, List<Item> item) {
        this.id = id;
        this.userId = userId;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public  Favorite toFavorite()
    {
        return new Favorite(
                null,
                this.userId,
                this.item
        );
    }

    public Favorite findFavoriteByUserId(FavoriteRequest userId) {
        return null;
    }

}
