package com.example.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * Primary used to represent and structure the response sent by the /find_ubs rest route
 */
@JsonPropertyOrder({ "currentPage", "perPage", "totalEntries", "entries" })
public class UbsList {
    private int currentPage, perPage;
    private long totalEntries;
    private List<Ubs> entries;

    public UbsList() { }

    public UbsList(int currentPage, int perPage, long totalEntries, List<Ubs> entries) {
        this.currentPage = currentPage;
        this.perPage = perPage;
        this.totalEntries = totalEntries;
        this.entries = entries;
    }

    @JsonProperty("current_page")
    public int getCurrentPage() {
        return currentPage;
    }

    @JsonProperty("current_page")
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @JsonProperty("per_page")
    public int getPerPage() {
        return perPage;
    }
    @JsonProperty("per_page")
    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    @JsonProperty("total_entries")
    public long getTotalEntries() {
        return totalEntries;
    }
    @JsonProperty("total_entries")
    public void setTotalEntries(long totalEntries) {
        this.totalEntries = totalEntries;
    }

    public List<Ubs> getEntries() {
        return entries;
    }

    public void setEntries(List<Ubs> entries) {
        this.entries = entries;
    }
}
