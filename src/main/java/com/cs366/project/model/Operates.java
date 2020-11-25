package com.cs366.project.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "operates")
public class Operates implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "bars", referencedColumnName = "name", nullable = false)
    private Bars bars;
    private Time start;
    private Time end;
    private String day;

    public Bars getBars() {
        return bars;
    }

    public void setBars(Bars bars) {
        this.bars = bars;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}

