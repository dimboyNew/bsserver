package com.domain.storage.service.impl;

import com.domain.specification.valueObject.Color;
import com.domain.specification.valueObject.Size;
import com.domain.storage.entity.Storage;
import com.domain.storage.service.GoodsStorageCalculateService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dimboy on 1/14/2017.
 */
@Service
public class GoodsStorageCalculateServiceImpl implements GoodsStorageCalculateService {
    @Override
    public Map<String,Storage> add(Map<String,Storage> s1, Map<String,Storage> s2) {
        List<Storage> storages = new ArrayList<>();


        s2.keySet().forEach(
                s->{
                    if(s1.get(s) == null){
                        s1.put(s,s2.get(s));
                    }else{
                        s1.get(s).setNum(s1.get(s).getNum());
                        s1.put(s,s1.get(s));
                    }
                }
        );

//        if(s1.getGoodsCode().equals(s2.getGoodsCode()) && s1.getColor().equals(s2.getColor()) && s1.getSize().equals(s2.getSize())){
//            String goodsCode = s1.getGoodsCode();
//            Color color = s1.getColor();
//            Size size = s1.getSize();
//
//            Storage storage = new Storage();
//
//            storage.setGoodsCode(goodsCode);
//            storage.setColor(s1.getColor());
//            storage.setSize(s1.getSize());
//
//            storage.setNum(s1.getNum() + s2.getNum());
//
//            storages.add(storage);
//        }else{
//
//            Storage ns1 = new Storage(s1);
//            Storage ns2 = new Storage(s2);
//
//            storages.add(ns1);
//            storages.add(ns2);
//        }

        return s1;
    }

    static final String APPENDIX = ",";
    public Map<String,Map<String,Storage>> groupStorages(List<Storage> storages){

        Map<String,Map<String,Storage>> map = new HashMap<>();
        storages.forEach(

                s -> {
                    Map<String,Storage> value = map.get(s.getStorageCode()) == null ? new HashMap<>() : map.get(s.getStorageCode());

                    String goodsKey = s.getGoodsCode() + APPENDIX + s.getColor().getId()+ APPENDIX + s.getSize().getId( );

                    if(value.get(goodsKey) != null) {value.get(goodsKey).setNum(s.getNum());};

                    Storage goodsNum = value.get(goodsKey) == null ? new Storage(s) : value.get(goodsKey);

                    value.put(goodsKey, goodsNum);

                    map.put(s.getStorageCode(),value);
                }
        );

        return map;
    }

}
