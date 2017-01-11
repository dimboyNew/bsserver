package com.domain.storage.controller;

import com.domain.storage.entity.Shop;
import com.domain.storage.entity.Storage;
import com.domain.storage.repository.ShopRepository;
import com.domain.storage.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dimboy on 1/11/2017.
 */
@RestController
@RequestMapping("storage")
public class StorageController {

    @Autowired
    StorageRepository sr;

    @Autowired
    ShopRepository shopRepository;

    @RequestMapping("searchStorage")
    @ResponseBody
    public List<Storage> searchStorage(String keyword) {

        List<Shop> shops = shopRepository.findAll();

        sr.getStorageView();
        List<Storage> storages = sr.findAll();

        return storages;
    }

}
