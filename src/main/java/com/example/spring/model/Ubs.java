package com.example.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;

/**
 * Binding class that represents the database registries, decorated with JPA notation.
 */
@Entity
@Table(name = "ubs")
@JsonPropertyOrder({ "id", "name", "address", "city", "phone", "geoCode", "scores" })
public class Ubs {
    @Id
    private long id;

    @Column(name = "nom_estab")
    private String name;
    @Column(name = "dsc_endereco")
    private String address;
    @Column(name = "dsc_cidade")
    private String city;

    @Column(name = "dsc_telefone")
    private String phone;

    @Embedded
    private GeoCode geoCode;

    @Embedded
    private UbsScores scores;

    public Ubs(long id, String name, String address,
               String city, double geoCodeLat, GeoCode geoCode,
               UbsScores scores) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.geoCode = geoCode;
        this.scores = scores;
    }

    public Ubs() {

    }

    public UbsScores getScores() {
        return scores;
    }

    public void setScores(UbsScores scores) {
        this.scores = scores;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @JsonProperty("geocode")
    public GeoCode getGeoCode() {
        return geoCode;
    }

    @JsonProperty("geocode")
    public void setGeoCode(GeoCode geoCode) {
        this.geoCode = geoCode;
    }
}
