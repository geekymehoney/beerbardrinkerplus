package com.cs366.project.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bars")
public class Bars implements Serializable
{
    @Id
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    private String license;
    private String city;
    private String phone;
    private String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
