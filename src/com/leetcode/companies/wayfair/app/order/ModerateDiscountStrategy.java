package com.leetcode.companies.wayfair.app.order;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   22-03-2025
    Time:   10:44 pm
*/

public class ModerateDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(Double price) {
        return price - (price * 20 / 100);
    }
}
