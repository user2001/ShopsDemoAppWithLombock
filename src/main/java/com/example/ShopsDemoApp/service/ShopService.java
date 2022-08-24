package com.example.ShopsDemoApp.service;

import com.example.ShopsDemoApp.entity.Shop;

import java.util.List;

public interface ShopService {
    public List<Shop> getShops();

    public Shop addShop(Shop shop);

    public void deleteShop(int shopId);

    public Shop getShop(int shopId);

    public Shop updateShop(Shop shop);
}
