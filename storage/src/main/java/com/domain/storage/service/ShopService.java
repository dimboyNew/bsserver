package com.domain.storage.service;

import com.domain.storage.entity.Shop;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by dimboy on 1/16/2017.
 */
public interface ShopService {

    public Map<String,Set<String>>  groupShop(List<Shop> shops);
}
