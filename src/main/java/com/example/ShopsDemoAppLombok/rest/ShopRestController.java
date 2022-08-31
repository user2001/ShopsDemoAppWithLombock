package com.example.ShopsDemoAppLombok.rest;

import com.example.ShopsDemoAppLombok.entity.Shop;
import com.example.ShopsDemoAppLombok.exception.ShopErrorResponse;
import com.example.ShopsDemoAppLombok.exception.ShopNotFoundException;
import com.example.ShopsDemoAppLombok.service.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ShopRestController {
    private ShopServiceImpl shopService;

    @Autowired
    public ShopRestController(ShopServiceImpl shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/shops")
    public HashMap<String, Shop> getShops() {
        return shopService.getShops();
    }

    @GetMapping("/shops/{shopId}")
    public Shop getShop(@PathVariable String shopId) {
        return shopService.getShop(shopId);
    }

    @PostMapping("/shops")
    public Shop addShop(@RequestBody Shop shop) {
        return shopService.addShop(shop);
    }

    @PutMapping(value = "/shops/{shopId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Shop updateShop(@PathVariable String shopId, @RequestBody Shop shop) {
        Shop temp = shopService.updateShop(shop, shopId);
        return temp;
    }

    @DeleteMapping("/shops/{shopId}")
    public String deleteShops(@PathVariable String shopId) {
        shopService.deleteShop(shopId);
        return "Shop with id: " + shopId + " was deleted";
    }

    @ExceptionHandler
    public ResponseEntity<ShopErrorResponse> handleException(ShopNotFoundException exc) {
        ShopErrorResponse error = new ShopErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
