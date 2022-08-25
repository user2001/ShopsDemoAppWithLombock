package com.example.ShopsDemoApp.service;

import com.example.ShopsDemoApp.entity.Shop;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class ShopServiceImpl implements ShopService {

    private HashMap<String, Shop> shopHashMap;

    @Override
    public HashMap<String, Shop> getShops() {
        return shopHashMap;
    }

    @Override
    public Shop addShop(Shop theShop) {
        String newShopId = UUID.randomUUID().toString();
        theShop.setId(newShopId);

        if (shopHashMap == null) shopHashMap = new HashMap<>();
        shopHashMap.put(newShopId, theShop);
        return theShop;
    }

    @Override
    public void deleteShop(String shopId) {
        shopHashMap.remove(shopId);
    }

    @Override
    public Shop getShop(String shopId) {
        return shopHashMap.get(shopId);
    }

    @Override
    public Shop updateShop(Shop shop, String shopId) {
        var temp = shopHashMap.get(shopId);
        temp.setCity(shop.getCity());
        temp.setShopName(shop.getShopName());
        temp.setStreet(shop.getStreet());
        temp.setCountOfWorkers(shop.getCountOfWorkers());
        temp.setWebsite(shop.isWebsite());
        return temp;
    }
}
