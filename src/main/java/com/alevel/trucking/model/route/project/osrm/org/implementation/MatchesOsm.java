package com.alevel.trucking.model.route.project.osrm.org.implementation;

import com.alevel.trucking.model.route.project.osrm.org.Coordinate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchesOsm implements Coordinate {

    private double lon;

    private double lat;

    public MatchesOsm() {
    }

    public MatchesOsm(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

}
