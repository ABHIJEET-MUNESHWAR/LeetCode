package com.leetcode.companies.wayfair.app.order;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   22-03-2025
    Time:   10:45 pm
*/

public class ExpensiveDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(Double price) {
        return price - (price * 30 / 100);
    }
}
