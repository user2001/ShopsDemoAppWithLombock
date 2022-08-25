package com.example.ShopsDemoApp.entity;

public class Shop {
    private String id;
    private String city;
    private String street;
    private String shopName;
    private int countOfWorkers;
    private boolean website;

    public Shop() {
    }

    public Shop
            (String city, String street, String shopName, int countOfWorkers, boolean website) {
        this.city = city;
        this.street = street;
        this.shopName = shopName;
        this.countOfWorkers = countOfWorkers;
        this.website = website;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getCountOfWorkers() {
        return countOfWorkers;
    }

    public void setCountOfWorkers(int countOfWorkers) {
        this.countOfWorkers = countOfWorkers;
    }

    public boolean isWebsite() {
        return website;
    }

    public void setWebsite(boolean website) {
        this.website = website;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Shop{" + " id= " + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", shopName='" + shopName + '\'' +
                ", countOfWorkers=" + countOfWorkers +
                ", website=" + website +
                '}';
    }
}