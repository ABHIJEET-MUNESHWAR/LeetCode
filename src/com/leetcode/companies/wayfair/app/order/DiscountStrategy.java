package com.leetcode.companies.wayfair.app.order;

public interface DiscountStrategy {
    double applyDiscount(Double price);
}
