package com.example.ShopsDemoApp.rest;

import com.example.ShopsDemoApp.entity.Shop;
import com.example.ShopsDemoApp.service.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShopRestController {
    private ShopServiceImpl shopService;

    @Autowired
    public ShopRestController(ShopServiceImpl shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/shops")
    public List<Shop> getShops(){
        return shopService.getShops();
    }

    @GetMapping("/shops/{shopId}")
    public Shop getShop(@PathVariable int shopId){
        Shop theShop=shopService.getShop(shopId);
        return theShop;
    }

    @PostMapping("/shops")
    public Shop addShop(@RequestBody Shop shop){
        return shopService.addShop(shop);
    }

    @PutMapping(value = "/shops/{shopId}",
            consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
    public Shop updateShop (@PathVariable int shopId, @RequestBody Shop shop){
Shop temp=shopService.getShop(shopId);
temp.setCity(shop.getCity());
temp.setShopName(shop.getShopName());
temp.setStreet(shop.getStreet());
temp.setCountOfWorkers(shop.getCountOfWorkers());
temp.setWebsite(shop.isWebsite());
        return temp;
    }
}
