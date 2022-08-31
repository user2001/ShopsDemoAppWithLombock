package com.example.ShopsDemoAppLombok.service;

import com.example.ShopsDemoAppLombok.entity.Shop;
import com.example.ShopsDemoAppLombok.exception.ShopNotFoundException;
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
        isFound(shopId);
        shopHashMap.remove(shopId);
    }

    @Override
    public Shop getShop(String shopId) {
        isFound(shopId);
        return shopHashMap.get(shopId);
    }

    @Override
    public Shop updateShop(Shop shop, String shopId) {
        isFound(shopId);
        var temp = shopHashMap.get(shopId);
        temp.setCity(shop.getCity());
        temp.setShopName(shop.getShopName());
        temp.setStreet(shop.getStreet());
        temp.setCountOfWorkers(shop.getCountOfWorkers());
        temp.setWebsite(shop.isWebsite());
        return temp;
    }

    public void isFound(String shopId){
        if(!shopHashMap.containsKey(shopId))
            throw new ShopNotFoundException(
                    "Shop with id: "+ shopId +" not found, try to put correct id");
    }
}
