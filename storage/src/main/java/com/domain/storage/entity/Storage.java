package com.domain.storage.entity;

import com.domain.specification.valueObject.Color;
import com.domain.specification.valueObject.Size;

import javax.persistence.*;
import java.util.HashMap;

/**
 * Created by dimboy on 1/10/2017.
 */
@Entity
@Table(name = "VW_CKJXCMX")
@NamedQuery(name = "getStorageGoods", query = "select goodsCode,storageCode, sum(num) as num from Storage group by goodsCode,storageCode having  sum(num) >0 ")
public class Storage {

    @Column(name = "spdm")
    private String goodsCode;

    @Id
    @Column(name = "ckdm")
    private String storageCode;

    @Column(name = "sl")
    private Long num;

    @OneToOne
    @JoinColumn(name = "GG1DM",referencedColumnName = "GGDM")
    //@Column(name = "GG1DM")
    //private Long colorId;
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /*@Column(name = "GG1DM")
    private Long colorId;*/

    //@Column(name = "GG2DM")
    @OneToOne
    @JoinColumn(name = "GG2DM")
    //private Long sizeId;
    private Size size;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Storage(){

    }

    public Storage(Storage storage) {
        if (storage == null){
            return;
        }

        this.setGoodsCode(storage.getGoodsCode());
        this.setColor(storage.getColor());
        this.setSize(storage.getSize());
        this.setNum(storage.getNum());
    }

}
