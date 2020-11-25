package com.cs366.project.model;

import com.cs366.project.model.compositekey.LikesCompositeKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "likes")
public class Likes implements Serializable {
    @MapsId("beers")
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "beers", referencedColumnName = "name", nullable = false)
    private Beers beers;

    @MapsId("drinkers")
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "drinkers", referencedColumnName = "name", nullable = false)
    private Drinkers drinkers;

    @AttributeOverrides(value =
            {@AttributeOverride(column = @Column(name="beer"), name = "beers"),
                    @AttributeOverride(column = @Column(name="drinker"), name = "drinkers"),
            })
    @EmbeddedId
    private LikesCompositeKey likesCompositeKey;

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

    public LikesCompositeKey getLikesCompositeKey() {
        return likesCompositeKey;
    }

    public void setLikesCompositeKey(LikesCompositeKey likesCompositeKey) {
        this.likesCompositeKey = likesCompositeKey;
    }
}
