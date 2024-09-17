package com.userLogin.model;

public class FavoriteRequest {
    private Long id;
    private Long userId;
    private Long itemId;

    public FavoriteRequest(Long id, Long userId, Long itemId) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Favorite toFavorite()
    {
        return new Favorite(
                null,
                this.userId,
               this.itemId
        );
    }



}
