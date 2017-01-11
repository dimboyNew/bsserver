package com.domain.storage.entity;

import com.domain.specification.valueObject.Color;
import com.domain.specification.valueObject.Size;

import javax.persistence.*;

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
    @JoinColumn(name = "GG1DM")
    //@Column(name = "GG1DM")
    //private Long colorId;
    private Color color;

    //@Column(name = "GG2DM")
    @OneToOne
    @JoinColumn(name = "GG2DM")
    //private Long sizeId;
    private Size size;
}
