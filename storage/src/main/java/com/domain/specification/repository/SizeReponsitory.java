package com.domain.specification.repository;

import com.domain.specification.valueObject.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by dimboy on 1/11/2017.
 */
@RepositoryRestResource
public interface SizeReponsitory extends JpaRepository<Color, Long> {
}
