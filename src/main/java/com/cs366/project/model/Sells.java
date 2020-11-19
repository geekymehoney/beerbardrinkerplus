package com.cs366.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Sells implements Serializable {
    @Id
    private String bar;
    private String beer;
    private double price;

    public String getBar() {
        return bar;
    }

    public void setBar(String barname) {
        this.bar = barname;
    }

    public String getBeer() {
        return beer;
    }

    public void setBeer(String beername) {
        this.beer = beername;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
