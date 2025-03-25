package com.leetcode.companies.wayfair.app.order;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   23-03-2025
    Time:   10:25 am
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderSystem implements IOrderSystem {
    private final List<IOrder> cart = new ArrayList<>();
    private final DiscountContext discountContext = new DiscountContext();


    @Override
    public void addToCart(IOrder order) {
        cart.add(order);
    }

    @Override
    public void removeFromCart(IOrder order) {
        cart.remove(order);
    }

    @Override
    public Map<String, Integer> cartItems() {
        Map<String, Integer> orderToItemsMap = new HashMap<>();
        for (IOrder order : cart) {
            orderToItemsMap.put(order.getName(), orderToItemsMap.getOrDefault(order.getName(), 0) + 1);
        }
        return orderToItemsMap;
    }


    private String determineCategory(double price) {
        if (price <= 10) {
            return "Cheap";
        }
        if (price < 20) {
            return "Moderate";
        }
        return "Expensive";
    }

    @Override
    public double calculateTotalAmount() {
        double total = 0;
        for (IOrder order : cart) {
            DiscountStrategy discountStrategy = discountContext.determineDiscountStrategy(order.getPrice());
            discountContext.setDiscountStrategy(discountStrategy);
            total += discountContext.applyDiscount(order.getPrice());
        }
        return total;
    }

    @Override
    public Map<String, Double> categoryDiscounts() {
        Map<String, Double> categoryToDiscountMap = new HashMap<>();
        for (IOrder order : cart) {
            DiscountStrategy discountStrategy = discountContext.determineDiscountStrategy(order.getPrice());
            discountContext.setDiscountStrategy(discountStrategy);
            Double discountedPrice = discountContext.applyDiscount(order.getPrice());
            Double discountedAmount = order.getPrice() - discountedPrice;
            String category = determineCategory(order.getPrice());
            categoryToDiscountMap.put(category, categoryToDiscountMap.getOrDefault(category, 0.0) + discountedAmount);
        }
        return categoryToDiscountMap;
    }
}
