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

public class BestCouponFinder {

    class Coupon {
        String couponName;
        LocalDate dateModified;

        public Coupon(String couponName, LocalDate dateModified) {
            this.couponName = couponName;
            this.dateModified = dateModified;
        }
    }

    Map<String, String> categoryToParentMap = new HashMap<>();
    Map<String, PriorityQueue<Coupon>> categoryToCouponsMap = new HashMap<>();
    Map<String, String> resolvedCategoryToCouponMap = new HashMap<>();

    public BestCouponFinder(String[][] coupons, String[][] categories) {
        loadCoupons(coupons);
        loadCategories(categories);
        preComputeBestCoupons();
    }

    private void loadCoupons(String[][] coupons) {
        for (String[] coupon : coupons) {
            String category = coupon[0];
            String couponName = coupon[1];
            String dateModified = coupon[2];

            LocalDate modifiedDate = LocalDate.parse(dateModified);
            if (modifiedDate.isAfter(LocalDate.now())) {
                continue;
            }
            categoryToCouponsMap
                    .computeIfAbsent(category, k -> new PriorityQueue<>(
                            (a, b) -> b.dateModified.compareTo(a.dateModified)
                    ))
                    .add(new Coupon(couponName, modifiedDate));
        }
    }

    private void loadCategories(String[][] categories) {
        for (String[] category : categories) {
            categoryToParentMap.put(category[0], category[1]);
        }
    }

    // ✅ Precompute best coupon for every category (including inherited)
    private void preComputeBestCoupons() {
        for (String category : categoryToParentMap.keySet()) {
            findAndCacheBestCoupon(category);
        }
    }

    private void findAndCacheBestCoupon(String category) {
        if (resolvedCategoryToCouponMap.containsKey(category)) {
            return;// Already resolved
        }
        // Try to find a coupon in the current category
        if (categoryToCouponsMap.containsKey(category) && !categoryToCouponsMap.get(category).isEmpty()) {
            resolvedCategoryToCouponMap.put(category, categoryToCouponsMap.get(category).peek().couponName);
            return;
        }

        // Try to inherit from parent
        String parentCoupon = categoryToParentMap.get(category);
        if (parentCoupon != null) {
            findAndCacheBestCoupon(parentCoupon);
            if (resolvedCategoryToCouponMap.containsKey(parentCoupon)) {
                resolvedCategoryToCouponMap.put(category, resolvedCategoryToCouponMap.get(parentCoupon));
            }
        }
    }

    // ✅ O(1) Lookup
    public String findBestCoupon(String category) {
        return resolvedCategoryToCouponMap.get(category);
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
        BestCouponFinder finder = new BestCouponFinder(coupons, categories);

        // Test Cases
        System.out.println(finder.findBestCoupon("Comforter Sets")); // Cozy Comforter Coupon
        System.out.println(finder.findBestCoupon("Bedding")); // Savings on Bedding or Best Bedding Bargains
        System.out.println(finder.findBestCoupon("Bed & Bath")); // Bed & Bath extravaganza
        System.out.println(finder.findBestCoupon("Bathroom Accessories")); // Bed & Bath extravaganza
        System.out.println(finder.findBestCoupon("Soap Dispensers")); // Bed & Bath extravaganza
        System.out.println(finder.findBestCoupon("Toy Organizers")); // null
    }
}
