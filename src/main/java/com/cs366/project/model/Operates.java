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
    private String start;
    private String end;
    private String day;

    public Bars getBars() {
        return bars;
    }

    public void setBars(Bars bars) {
        this.bars = bars;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}

