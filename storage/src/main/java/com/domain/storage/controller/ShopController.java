package com.domain.storage.controller;

import com.domain.storage.entity.Shop;
import com.domain.storage.entity.Storage;
import com.domain.storage.repository.ShopRepository;
import com.domain.storage.repository.StorageRepository;
import com.domain.storage.service.GoodsStorageCalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("view")
    @ResponseBody
    List<Shop> findShopsWithStorage(String shopName){

        List<Shop> allShops = shopRepository.findAll();

        List<Storage> allStorages = storageRepository.getStorageView();

        Map<String, Map<String, Storage>> map = service.groupStorages(allStorages);

        for (Shop shop : allShops) {
            List<Storage> storages = new ArrayList<>();
            Map<String, Storage> value = new HashMap<>();
            shop.getStorages().forEach(
                    s-> {
                        service.add(value,map.get(s.getStorageCode()));
                    }
            );

            value.forEach((key,s)->{
                storages.add(s);
            });

            shop.setStorages(storages);
        }
        return allShops;
    }
}
