package com.domain.storage.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dimboy on 1/10/2017.
 */
@Entity
@Table(name = "CangKu")
@Embeddable
@NamedQuery(name = "getShop", query = "select DISTINCT shopName as name from  Shop ")
public class Shop {

    @Id
    @Column(name = "CKMC")
    private String shopName;

    @OneToMany
    @JoinTable(name= "CangKu",joinColumns = @JoinColumn(name = "CKDM"))
    private List<Storage> storages;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setStorages(List<Storage> storages) {
        this.storages = storages;
    }

    public List<Storage> getStorages() {
        return storages;
    }
}
