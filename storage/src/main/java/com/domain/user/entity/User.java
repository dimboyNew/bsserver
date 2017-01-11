package com.domain.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dimboy on 1/10/2017.
 */
@Entity
@Table(name = "UserParams")
public class User {

    //@Column(name = "vUserCode")
    //private String name;

    @Id
    @Column(name = "vUserCode")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
