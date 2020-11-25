package com.cs366.project.model.compositekey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LikesCompositeKey implements Serializable {

    @Column(name = "beers")
    private String beers;

    @Column(name = "drinkers")
    private String drinkers;

    public LikesCompositeKey(String beers, String drinkers) {
        this.beers = beers;
        this.drinkers = drinkers;
    }

    public LikesCompositeKey() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikesCompositeKey that = (LikesCompositeKey) o;
        return Objects.equals(beers, that.beers) &&
                Objects.equals(drinkers, that.drinkers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beers, drinkers);
    }
}
