package com.bluebus.adminservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "busroute")
@Getter
@Setter
public class BusRoute {
    @Id
    @Column(name = "busnumber", nullable = false, length = Integer.MAX_VALUE)
    private String busnumber;

    @Column(name = "source", length = Integer.MAX_VALUE)
    private String source;

    @Column(name = "destination", length = Integer.MAX_VALUE)
    private String destination;

    @Column(name = "price", length = Integer.MAX_VALUE)
    private String price;

}