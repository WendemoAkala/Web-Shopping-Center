package com.userLogin.model;

public class UserAddress {
    private String Country;
    private String City;

    public UserAddress(String country, String city) {
        this.Country = country;
        this.City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
