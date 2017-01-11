package com.domain.storage.repository;

import com.domain.storage.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by dimboy on 1/10/2017.
 */
@RepositoryRestResource

public interface StorageRepository extends JpaRepository<Storage, String> {

    @RestResource(path = "by-storageCode")
    public List<Storage> findByStorageCode(@RequestParam String storageCode);

    @Query(value = "select goodsCode,storageCode,color,sum(num) as num from Storage  group by goodsCode,storageCode,color having  sum(num) >0 ")
    public List<Object[]> getStorageView();

}
