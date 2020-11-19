package com.cs366.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Beer implements Serializable {
    @Id
    private String name;
    private String manf;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManf() {
        return manf;
    }

    public void setManf(String manf) {
        this.manf = manf;
    }
}
