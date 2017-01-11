package com.domain.specification.valueObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dimboy on 1/11/2017.
 */
@Entity
@Table(name = "GuiGe2")
public class Size {

    @Id
    @Column(name = "GGDM")
    private long id;

    @Column(name = "GGMC")
    private String size;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}