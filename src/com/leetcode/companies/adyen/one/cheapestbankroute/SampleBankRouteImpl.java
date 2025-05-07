package com.leetcode.companies.adyen.one.cheapestbankroute;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   07-05-2025
    Time:   11:59 am
*/

public class SampleBankRouteImpl implements BankRoute {
    private final String source;
    private final String destination;
    private final int cost;

    public SampleBankRouteImpl(String source, String destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }
}
