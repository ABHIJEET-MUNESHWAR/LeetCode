package com.leetcode.companies.wayfair.app.couponfinder;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   23-03-2025
    Time:   12:16 pm
*/

import java.util.HashMap;
import java.util.Map;

public class CouponFinder {
    private Map<String, String> categoryToCouponMap = new HashMap<>();
    private Map<String, String> categoryToParentMap = new HashMap<>();

    public CouponFinder(String[][] coupons, String[][] categories) {
        // Load categories into the map
        for (String[] coupon : coupons) {
            categoryToCouponMap.put(coupon[0], coupon[1]);
        }
        // Load coupons into the map
        for (String[] category : categories) {
            categoryToParentMap.put(category[0], category[1]);
        }
    }

    public String findCoupon(String category) {
        if (category == null || category.equals("")) {
            return null;
        }
        if (categoryToCouponMap.containsKey(category)) {
            return categoryToCouponMap.get(category);
        }
        String coupon = null;
        String parentCategory = categoryToParentMap.get(category);
        if (parentCategory != null) {
            coupon = findCoupon(parentCategory);
        }
        if (coupon != null) {
            categoryToCouponMap.put(category, coupon);
        }
        return coupon;
    }

    public static void main(String[] args) {
        // Input data
        String[][] coupons = {
                {"Comforter Sets", "Comforters Sale"},
                {"Bedding", "Savings on Bedding"},
                {"Bed & Bath", "Low price for Bed & Bath"}
        };

        String[][] categories = {
                {"Comforter Sets", "Bedding"},
                {"Bedding", "Bed & Bath"},
                {"Bed & Bath", null},
                {"Soap Dispensers", "Bathroom Accessories"},
                {"Bathroom Accessories", "Bed & Bath"},
                {"Toy Organizers", "Baby And Kids"},
                {"Baby And Kids", null}
        };
        CouponFinder finder = new CouponFinder(coupons, categories);
        // Test cases
        System.out.println(finder.findCoupon("Comforter Sets")); // "Comforters Sale"
        System.out.println(finder.findCoupon("Bedding")); // "Savings on Bedding"
        System.out.println(finder.findCoupon("Bathroom Accessories")); // "Low price for Bed & Bath"
        System.out.println(finder.findCoupon("Soap Dispensers")); // "Low price for Bed & Bath"
        System.out.println(finder.findCoupon("Toy Organizers")); // null
    }
}
