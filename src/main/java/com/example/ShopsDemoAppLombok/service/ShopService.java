package com.example.ShopsDemoAppLombok.service;

import com.example.ShopsDemoAppLombok.entity.Shop;

import java.util.HashMap;

public interface ShopService {
    public HashMap<String, Shop> getShops();

    public Shop addShop(Shop shop);

    public void deleteShop(String shopId);

    public Shop getShop(String shopId);

    public Shop updateShop(Shop shop, String shopId);
}
