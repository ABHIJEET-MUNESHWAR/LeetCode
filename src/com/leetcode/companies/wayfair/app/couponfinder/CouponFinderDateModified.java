package com.leetcode.companies.wayfair.app.couponfinder;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   23-03-2025
    Time:   03:39 pm
*/

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CouponFinderDateModified {
    class Coupon {
        String couponName;
        LocalDate dateModified;

        public Coupon(String couponName, LocalDate dateModified) {
            this.couponName = couponName;
            this.dateModified = dateModified;
        }
    }

    private Map<String, String> categoryToParentMap = new HashMap<>();
    private Map<String, PriorityQueue<Coupon>> categoryToCouponsMap = new HashMap<>();
    private Map<String, String> resolvedCategoryToCoupons = new HashMap<>();

    public CouponFinderDateModified(String[][] coupons, String[][] categories) {
        // Load category hierarchy
        for (String[] category : categories) {
            categoryToParentMap.put(category[0], category[1]);
        }
        // Load coupons with date handling
        for (String[] coupon : coupons) {
            String category = coupon[0];
            String couponName = coupon[1];
            String dateModified = coupon[2];

            LocalDate modifiedDate = LocalDate.parse(dateModified);
            if (modifiedDate.isAfter(LocalDate.now())) {
                continue; // Ignore future coupons
            }

            categoryToCouponsMap
                    .computeIfAbsent(category, k -> new PriorityQueue<>(
                            (a, b) -> b.dateModified.compareTo(a.dateModified)
                    ))
                    .add(new Coupon(couponName, modifiedDate));
        }
    }

    public String findCoupon(String category) {
        if (category == null || category.isEmpty()) {
            return null;
        }
        // If already resolved using memoization, return directly
        if (resolvedCategoryToCoupons.containsKey(category)) {
            return resolvedCategoryToCoupons.get(category);
        }

        // If coupons exist for the category, pick the latest one
        if (categoryToCouponsMap.containsKey(category) && !categoryToCouponsMap.get(category).isEmpty()) {
            Coupon latestCoupon = categoryToCouponsMap.get(category).peek();
            resolvedCategoryToCoupons.put(category, latestCoupon.couponName);
            return latestCoupon.couponName;
        }

        // If no coupon, inherit from parent category
        String parentCategory = categoryToParentMap.get(category);
        String coupon = null;
        if (parentCategory != null) {
            coupon = findCoupon(parentCategory);
        }
        if (coupon != null) {
            resolvedCategoryToCoupons.put(category, coupon);
        }
        return coupon;
    }

    public static void main(String[] args) {
        // Input Data
        String[][] coupons = {
                {"Comforter Sets", "Comforters Sale", "2020-01-01"},
                {"Comforter Sets", "Cozy Comforter Coupon", "2021-01-01"},
                {"Bedding", "Best Bedding Bargains", "2019-01-01"},
                {"Bedding", "Savings on Bedding", "2019-01-01"},
                {"Bed & Bath", "Low price for Bed & Bath", "2018-01-01"},
                {"Bed & Bath", "Bed & Bath extravaganza", "2019-01-01"},
                {"Bed & Bath", "Big Savings for Bed & Bath", "2030-01-01"} // Future date ignored
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

        // Initialize Finder
        CouponFinderDateModified finder = new CouponFinderDateModified(coupons, categories);

        // Test Cases
        System.out.println(finder.findCoupon("Comforter Sets")); // Cozy Comforter Coupon
        System.out.println(finder.findCoupon("Bedding")); // Savings on Bedding or Best Bedding Bargains
        System.out.println(finder.findCoupon("Bed & Bath")); // Bed & Bath extravaganza
        System.out.println(finder.findCoupon("Bathroom Accessories")); // Bed & Bath extravaganza
        System.out.println(finder.findCoupon("Soap Dispensers")); // Bed & Bath extravaganza
        System.out.println(finder.findCoupon("Toy Organizers")); // null
    }
}
