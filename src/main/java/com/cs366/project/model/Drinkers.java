package com.cs366.project.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "drinkers")
public class Drinkers implements Serializable {
    @Id
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    private String phone;
    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
