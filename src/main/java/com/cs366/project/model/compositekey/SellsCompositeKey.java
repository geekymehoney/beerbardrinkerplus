package com.cs366.project.model.compositekey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SellsCompositeKey implements Serializable {

    @Column(name = "beers")
    private String beers;

    @Column(name = "bars")
    private String bars;

    public SellsCompositeKey(String beers, String bars) {
        this.beers = beers;
        this.bars = bars;
    }

    public SellsCompositeKey() {

    }

    public String getBeers() {
        return beers;
    }

    public void setBeers(String beers) {
        this.beers = beers;
    }

    public String getBars() {
        return bars;
    }

    public void setBars(String bars) {
        this.bars = bars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellsCompositeKey that = (SellsCompositeKey) o;
        return Objects.equals(beers, that.beers) &&
                Objects.equals(bars, that.bars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beers, bars);
    }
}
