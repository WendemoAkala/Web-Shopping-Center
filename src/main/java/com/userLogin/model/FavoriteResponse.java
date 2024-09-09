package com.userLogin.model;

public class FavoriteResponse {
    private Long id;
    private Long userId;
    private Item item;

    public FavoriteResponse(Long id, Long userId, Item item) {
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
