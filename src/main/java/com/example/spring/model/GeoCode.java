package com.example.spring.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Class to complement the UBS model, following the corresponding data structure
 */
@Embeddable
@JsonPropertyOrder({ "lat", "lon" })
public class GeoCode {
    @Column(name = "vlr_latitude")
    private double lat;
    @Column(name = "vlr_longitude")
    private double lon;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
