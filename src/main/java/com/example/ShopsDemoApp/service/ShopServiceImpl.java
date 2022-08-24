package com.example.ShopsDemoApp.service;

import com.example.ShopsDemoApp.entity.Shop;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{

    private List<Shop> listOfShops;
private int count=1;

    @PostConstruct
    public void loadData(){
        listOfShops=new ArrayList<>();
        listOfShops.add(new Shop(count,
                "Lviv","Lukasha","Rozetka",20,true));
        listOfShops.add(new Shop(++count,
                "Kyiv","Bandery","Opel",50,false));
        listOfShops.add(new Shop(++count,
                "Poltava","Shevchenka ","Reno",60,true));
    }

    @Override
    public List<Shop> getShops() {
        return listOfShops;
    }

    @Override
    public Shop addShop(Shop shop) {
        listOfShops.add(shop);
        return shop;
    }

    @Override
    public void deleteShop(int shopId) {

    }

    @Override
    public Shop getShop(int shopId) {
        Shop theShop=listOfShops.get(shopId);
        return theShop;
    }

    @Override
    public Shop updateShop(Shop shop) {
        listOfShops.get(shop.getId());
        return listOfShops.set(shop.getId(),shop);
    }
}
