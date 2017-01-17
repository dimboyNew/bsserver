package com.domain.storage.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dimboy on 1/10/2017.
 */
@Entity
@Table(name = "CangKu")
//@SqlResultSetMapping(name = "getShop",
//        entities=@EntityResult(entityClass=Shop.class,
//        fields = {
//                @FieldResult(name="shopName", column = "CKMC")
//        }),
//        columns = { @ColumnResult(name = "shopName")})
//@SqlResultSetMapping("select DISTINCT shopName as name from  Shop)
public class Shop {

    @Id
    @Column(name = "CKMC")
    private String shopName;

    @Column(name = "CKDM")
    private String storageCode;

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    //    @OneToMany(fetch = FetchType.EAGER)//(mappedBy = "shop")
//    @JoinColumn(name = "CKDM")
    @Transient
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
