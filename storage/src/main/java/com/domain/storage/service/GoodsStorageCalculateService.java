package com.domain.storage.service;

import com.domain.storage.entity.Storage;

import java.util.List;
import java.util.Map;

/**
 * Created by dimboy on 1/14/2017.
 */
public interface GoodsStorageCalculateService {
    public Map<String,Storage> add(Map<String,Storage> s1, Map<String,Storage> s2);

    public Map<String,Map<String,Storage>> groupStorages(List<Storage> storages);
}
