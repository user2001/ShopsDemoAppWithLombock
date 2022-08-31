package com.example.ShopsDemoApp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Shop {
    private String id;
    private String city;
    private String street;
    private String shopName;
    private int countOfWorkers;
    private boolean website;

    public Shop
            (String city, String street, String shopName, int countOfWorkers, boolean website) {
        this.city = city;
        this.street = street;
        this.shopName = shopName;
        this.countOfWorkers = countOfWorkers;
        this.website = website;
    }

}