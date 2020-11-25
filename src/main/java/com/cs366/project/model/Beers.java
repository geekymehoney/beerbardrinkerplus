package com.cs366.project.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "beers")
public class Beers implements Serializable {

    @Id
    @Column(name = "name", nullable = false)
    private String name;
    private String manf;
    private double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
