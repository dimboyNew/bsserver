package com.domain.storage.service.impl;

import com.domain.storage.entity.Shop;
import com.domain.storage.service.ShopService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by dimboy on 1/16/2017.
 */
@Service
public class ShopServiceImpl implements ShopService {
    public Map<String, Set<String>> groupShop(List<Shop> shops) {
        Map<String, Set<String>> shopMap = new HashMap<>();

        shops.forEach(
                shop -> {
                    String key = shop.getShopName();
                    String value = shop.getStorageCode();

                    Set<String> set =  shopMap.get(key) == null ? new HashSet<>() : shopMap.get(key);
                    if(shopMap.get(key) == null){
                        set.add(value);
                    }

                    shopMap.put(key,set);
                }
        );

        return shopMap;
    }
}
