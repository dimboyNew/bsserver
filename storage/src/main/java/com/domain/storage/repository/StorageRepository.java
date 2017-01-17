package com.domain.storage.repository;

import com.domain.specification.valueObject.Color;
import com.domain.specification.valueObject.Size;
import com.domain.storage.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.util.List;

/**
 * Created by dimboy on 1/10/2017.
 */
@RepositoryRestResource

public interface StorageRepository extends JpaRepository<Storage, String> {

    @RestResource(path = "by-storageCode")
    public List<Storage> findByStorageCode(@RequestParam String storageCode);

    //@Query(value = "select goodsCode,storageCode,color,sum(num) as num from Storage s join s.color group by goodsCode,storageCode,color having  sum(num) >0 ")

    @Query(name = "getStorage", value = "select new Storage(s.goodsCode,s.storageCode,s.color,s.size,SUM(s.num) as num) from Storage s left join s.color c left join s.size z group by s.color,c.id,c.color,s.goodsCode,s.storageCode,s.size,z.id,z.size  having SUM(s.num) > 0 ")
    public List<Storage> getStorageView();

}
