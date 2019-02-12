package com.tracking.adminoperationssoap.dao;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Robi on 12/29/2018.
 */

@Entity
@Table(name = "routes")
@IdClass(RoutePK.class)
public class Route implements Serializable {
    @Id
    @Column(name = "awb")
    private int awb;
    @Id
    @Column(name = "route_nr")
    private int routeNr;
    @Column(name = "city")
    private String city;
    @Column(name = "receive_time")
    private String receiveTime;

    public int getAwb() {
        return awb;
    }

    public void setAwb(int awb) {
        this.awb = awb;
    }

    public int getRouteNr() {
        return routeNr;
    }

    public void setRouteNr(int routeNr) {
        this.routeNr = routeNr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }
}
