package com.cs366.project.model.compositekey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FrequentCompositeKey implements Serializable {

    @Column(name = "bars")
    private String bars;

    @Column(name = "drinkers")
    private String drinkers;

    public FrequentCompositeKey(String bars, String drinkers) {
        this.bars = bars;
        this.drinkers = drinkers;
    }

    public FrequentCompositeKey() {

    }

    public String getBars() {
        return bars;
    }

    public void setBars(String bar) {
        this.bars = bar;
    }

    public String getDrinkers() {
        return drinkers;
    }

    public void setDrinkers(String drinker) {
        this.drinkers = drinker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrequentCompositeKey that = (FrequentCompositeKey) o;
        return Objects.equals(bars, that.bars) &&
                Objects.equals(drinkers, that.drinkers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bars, drinkers);
    }
}
