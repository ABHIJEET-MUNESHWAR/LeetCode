package com.leetcode.companies.wayfair.lld.automatedparkinglot.src.model;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   26-03-2025
    Time:   11:40 am
*/

public class VacantSpot {
    Integer small;
    Integer medium;
    Integer large;

    public VacantSpot(Integer small, Integer medium, Integer large) {
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    public Integer getSmall() {
        return small;
    }

    public void setSmall(Integer small) {
        this.small = small;
    }

    public Integer getMedium() {
        return medium;
    }

    public void setMedium(Integer medium) {
        this.medium = medium;
    }

    public Integer getLarge() {
        return large;
    }

    public void setLarge(Integer large) {
        this.large = large;
    }
}
