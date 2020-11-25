package com.cs366.project.model;

import com.cs366.project.model.compositekey.SellsCompositeKey;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "sells")
public class Sells implements Serializable {
    @MapsId("bars")
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "bars", referencedColumnName = "name", nullable = false)
    private Bars bars;

    @MapsId("beers")
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "beers", referencedColumnName = "name", nullable = false)
    private Beers beers;

    @AttributeOverrides(value =
            {@AttributeOverride(column = @Column(name="beers"), name = "beers"),
                    @AttributeOverride(column = @Column(name="bars"), name = "bars"),
            })
    @EmbeddedId
    SellsCompositeKey sellsCompositeKey;
    private BigDecimal price;


    public Bars getBars() {
        return bars;
    }

    public void setBars(Bars bar) {
        this.bars = bar;
    }

    public Beers getBeers() {
        return beers;
    }

    public void setBeers(Beers beers) {
        this.beers = beers;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public SellsCompositeKey getSellsCompositeKey() {
        return sellsCompositeKey;
    }

    public void setSellsCompositeKey(SellsCompositeKey sellsCompositeKey) {
        this.sellsCompositeKey = sellsCompositeKey;
    }
}
