package com.leetcode.companies.adyen.one.cheapestbankroute;

public interface BankRoute {
    String getSource();

    String getDestination();

    int getCost();
}