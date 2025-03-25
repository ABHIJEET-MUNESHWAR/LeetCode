package com.leetcode.companies.wayfair.app.order;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   22-03-2025
    Time:   10:43 pm
*/

public class CheapDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(Double price) {
        return price - (price * 10 / 100);
    }
}
