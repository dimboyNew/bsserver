package com.domain.specification.valueObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dimboy on 1/11/2017.
 */
@Entity
@Table(name = "GuiGe1")
public class Color {

    @Id
    @Column(name = "GGDM")
    private String id;

    @Column(name = "GGMC")
    private String color;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
