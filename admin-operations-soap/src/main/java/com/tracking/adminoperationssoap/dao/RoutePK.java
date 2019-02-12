package com.tracking.adminoperationssoap.dao;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Robi on 12/29/2018.
 */
public class RoutePK implements Serializable {
    protected int awb;
    protected int routeNr;

    public RoutePK(int awb, int routeNr) {
        this.awb = awb;
        this.routeNr = routeNr;
    }

    public RoutePK() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoutePK)) return false;
        RoutePK that = (RoutePK) o;
        return Objects.equals(getAwb(), that.getAwb()) &&
                Objects.equals(getRouteNr(), that.getRouteNr());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAwb(), getRouteNr());
    }


}
