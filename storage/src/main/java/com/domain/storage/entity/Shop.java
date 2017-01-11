package com.domain.storage.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dimboy on 1/10/2017.
 */
@Entity
@Table(name = "CangKu")
@NamedQuery(name = "getShop", query = "select DISTINCT shopName as name from  Shop ")
public class Shop {

    @Id
    @Column(name = "CKMC")
    private String shopName;

    @OneToMany
    @Column(name = "CKDM")
    private List<Storage> storages;

}
