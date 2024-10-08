package com.userLogin.model;

public class ItemRequest {
    private Long id;
    private String title;
    private String photoUrl;
    private double price;
    private int stockCount;


    public ItemRequest(Long id, String title, String photoUrl, double price, int stockCount) {
        this.id = id;
        this.title = title;
        this.photoUrl = photoUrl;
        this.price = price;
        this.stockCount = stockCount;
    }

    public ItemRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public Item toItem(){

        return new Item(
                null,
                this.title,
                this.photoUrl,
                this.price,
                this.stockCount
        );
    }

}
