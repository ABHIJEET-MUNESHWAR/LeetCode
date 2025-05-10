package com.leetcode.companies.adyen.one.cheapestbankroute;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   07-05-2025
    Time:   12:13 pm
*/

public class RoutesState {
    String currentBank;
    int    cost;
    int    intermediaries;

    public RoutesState(String currentBank, int cost, int intermediaries) {
        this.currentBank = currentBank;
        this.cost = cost;
        this.intermediaries = intermediaries;
    }
}
