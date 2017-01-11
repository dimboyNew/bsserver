package com.domain.user.repository;

import com.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dimboy on 1/10/2017.
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, String> {

    @RestResource(path = "by-name")
    public User findByUsername(@RequestParam String username);

}
