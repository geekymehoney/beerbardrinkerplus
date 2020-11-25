package com.cs366.project.model;

import com.cs366.project.model.compositekey.BillsCompositeKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bills")
public class Bills implements Serializable {

    @Column(name = "bill_id", nullable = false, insertable = false, updatable = false)
    private String bill_id;

    @AttributeOverrides(value =
            {@AttributeOverride(column = @Column(name="beers"), name = "beers"),
                    @AttributeOverride(column = @Column(name="bill_id"), name = "bill_id"),
                    @AttributeOverride(column = @Column(name="quantity"), name = "quantity")
            })
    @EmbeddedId
    private BillsCompositeKey billsCompositeKey;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "bars", referencedColumnName = "name", nullable = false)
    private Bars bars;

    @MapsId("beers")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "beers", referencedColumnName = "name", nullable = false)
    private Beers beers;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "drinkers", referencedColumnName = "name", nullable = false)
    private Drinkers drinkers;
    private double total_price;
    private String time;
    private String day;
    private String date;

    @Column(name = "quantity", nullable = false, insertable = false, updatable = false)
    private int quantity;

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public BillsCompositeKey getBillsCompositeKey() {
        return billsCompositeKey;
    }

    public void setBillsCompositeKey(BillsCompositeKey billsCompositeKey) {
        this.billsCompositeKey = billsCompositeKey;
    }

    public Bars getBars() {
        return bars;
    }

    public void setBars(Bars bars) {
        this.bars = bars;
    }

    public Beers getBeers() {
        return beers;
    }

    public void setBeers(Beers beers) {
        this.beers = beers;
    }

    public Drinkers getDrinkers() {
        return drinkers;
    }

    public void setDrinkers(Drinkers drinkers) {
        this.drinkers = drinkers;
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
