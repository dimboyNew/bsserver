package com.domain.storage.controller;

import com.domain.storage.entity.Shop;
import com.domain.storage.entity.Storage;
import com.domain.storage.repository.ShopRepository;
import com.domain.storage.repository.StorageRepository;
import com.domain.storage.service.GoodsStorageCalculateService;
import com.domain.storage.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by dimboy on 1/14/2017.
 */
@RestController
@RequestMapping("shop")
public class ShopController {

    @Autowired
    StorageRepository storageRepository;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    GoodsStorageCalculateService service;

    @Autowired
    ShopService shopService;

    @RequestMapping("view")
    @ResponseBody
    List<Shop> findShopsWithStorage(String shopName) {


        List<Shop> allShops = shopRepository.findAll();//shopRepository.findDistictShop();
        Map<String,Set<String>> shopMap = shopService.groupShop(allShops);

        List<Storage> allStorages = storageRepository.getStorageView();

        Map<String, Map<String, Storage>> map = service.groupStorages(allStorages);

        List<Shop> shopView = new ArrayList<>();
        shopMap.forEach(

                (key,set)->{
                    Shop shop = new Shop();

                    List<Storage> storages = new ArrayList<>();
                    Map<String, Storage> value = new HashMap<>();

                    set.forEach(
                            s -> {
                                service.add(value, map.get(s));
                            }
                    );

                    value.forEach((k, s) -> {
                        if(k != null) {
                            storages.add(s);
                        }
                    });

                    shop.setShopName(key);
                    shop.setStorages(storages);
                    shopView.add(shop);
                }
        );

        /*for (Shop shop : allShops) {
            List<Storage> storages = new ArrayList<>();
            Map<String, Storage> value = new HashMap<>();
            shop.getStorages().forEach(
                    s -> {
                        service.add(value, map.get(s.getStorageCode()));
                    }
            );

            value.forEach((key, s) -> {
                storages.add(s);
            });

            shop.setStorages(storages);
        }*/
        return shopView;
    }
}
