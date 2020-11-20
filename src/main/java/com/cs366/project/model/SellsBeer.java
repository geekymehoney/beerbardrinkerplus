package com.cs366.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "sellsbeer")
public class SellsBeer implements Serializable {
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
