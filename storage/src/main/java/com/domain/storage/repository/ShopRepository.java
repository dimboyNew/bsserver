package com.domain.storage.repository;

import com.domain.storage.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by dimboy on 1/11/2017.
 */
@RepositoryRestResource
public interface ShopRepository extends JpaRepository<Shop, String> {


}
