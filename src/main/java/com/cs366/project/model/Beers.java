package com.cs366.project.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "beers")
public class Beers implements Serializable {

    @Id
    @Column(name = "name", nullable = false)
    private String name;
    private String manf;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManf() {
        return manf;
    }

    public void setManf(String manf) {
        this.manf = manf;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
