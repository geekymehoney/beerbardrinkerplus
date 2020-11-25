package com.cs366.project.model;

import com.cs366.project.model.compositekey.FrequentCompositeKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "frequents")
public class Frequents implements Serializable {


    @AttributeOverrides(value =
            {@AttributeOverride(column = @Column(name="bars"), name = "bars"),
                    @AttributeOverride(column = @Column(name="drinkers"), name = "drinkers"),
            })
    @EmbeddedId
    private FrequentCompositeKey frequentCompositeKey;

    @MapsId("bars")
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "bars", referencedColumnName = "name", nullable = false)
    private Bars bars;

    @MapsId("drinkers")
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "drinkers", referencedColumnName = "name", nullable = false)
    private Drinkers drinkers;

    public Bars getBars() {
        return bars;
    }

    public void setBars(Bars bars) {
        this.bars = bars;
    }

    public Drinkers getDrinkers() {
        return drinkers;
    }

    public void setDrinkers(Drinkers drinkers) {
        this.drinkers = drinkers;
    }

    public FrequentCompositeKey getFrequentCompositeKey() {
        return frequentCompositeKey;
    }

    public void setFrequentCompositeKey(FrequentCompositeKey frequentCompositeKey) {
        this.frequentCompositeKey = frequentCompositeKey;
    }
}
