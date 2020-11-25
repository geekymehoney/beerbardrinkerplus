package com.cs366.project.model.responsemodel;
import java.math.BigDecimal;

public class BillsResponse {
    private String bill_id;
    private String bars;
    private String beers;
    private String drinkers;
    private BigDecimal total_price;
    private String time;
    private String day;
    private String date;
    private int quantity;

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public String getBars() {
        return bars;
    }

    public void setBars(String bars) {
        this.bars = bars;
    }

    public String getBeers() {
        return beers;
    }

    public void setBeers(String beers) {
        this.beers = beers;
    }

    public String getDrinkers() {
        return drinkers;
    }

    public void setDrinkers(String drinkers) {
        this.drinkers = drinkers;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
