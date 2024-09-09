package com.userLogin.model;

public class UserAddressResponse {
    private String Country;
    private String City;

    public UserAddressResponse(String country, String city) {
        Country = country;
        City = city;
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
