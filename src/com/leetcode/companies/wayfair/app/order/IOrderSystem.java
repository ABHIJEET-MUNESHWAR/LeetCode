package com.leetcode.companies.wayfair.app.order;

import java.util.Map;

public interface IOrderSystem {
    void addToCart(IOrder order);

    void removeFromCart(IOrder order);

    double calculateTotalAmount();

    Map<String, Double> categoryDiscounts();

    Map<String, Integer> cartItems();
}
