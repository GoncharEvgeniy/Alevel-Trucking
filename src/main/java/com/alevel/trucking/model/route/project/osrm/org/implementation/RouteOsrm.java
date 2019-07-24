package com.alevel.trucking.model.route.project.osrm.org.implementation;

import com.alevel.trucking.model.route.project.osrm.org.Distance;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteOsrm implements Distance {

    private double distance;

    public RouteOsrm() {
    }

    public RouteOsrm(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

}
