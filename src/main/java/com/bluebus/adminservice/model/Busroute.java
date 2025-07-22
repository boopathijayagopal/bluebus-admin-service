package com.bluebus.adminservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "busroute")
public class Busroute {
    @Id
    @Column(name = "busnumber", nullable = false, length = Integer.MAX_VALUE)
    private String busnumber;

    @Column(name = "source", length = Integer.MAX_VALUE)
    private String source;

    @Column(name = "destination", length = Integer.MAX_VALUE)
    private String destination;

    @Column(name = "price", length = Integer.MAX_VALUE)
    private String price;

    public String getBusnumber() {
        return busnumber;
    }

    public void setBusnumber(String busnumber) {
        this.busnumber = busnumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}