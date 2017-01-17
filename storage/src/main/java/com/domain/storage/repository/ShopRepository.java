package com.domain.storage.repository;

import com.domain.storage.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by dimboy on 1/11/2017.
 */
@RepositoryRestResource
public interface ShopRepository extends JpaRepository<Shop, String> {

    //@Query(value = "select distinct  s from Shop s left join s.storages")
    //public List<Shop> findDistictShop();

}
