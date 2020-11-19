package com.cs366.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Bills implements Serializable {
@Id
private String bill_id;
private String bar;
private String date;
private String drinker;
private double items_price;
private double tax_price;
private double tip;
private double total_price;
private String time;
private String bartender;
private String day;

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDrinker() {
        return drinker;
    }

    public void setDrinker(String drinker) {
        this.drinker = drinker;
    }

    public double getItems_price() {
        return items_price;
    }

    public void setItems_price(double items_price) {
        this.items_price = items_price;
    }

    public double getTax_price() {
        return tax_price;
    }

    public void setTax_price(double tax_price) {
        this.tax_price = tax_price;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBartender() {
        return bartender;
    }

    public void setBartender(String bartender) {
        this.bartender = bartender;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
