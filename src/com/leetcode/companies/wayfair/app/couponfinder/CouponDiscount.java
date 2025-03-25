package com.leetcode.companies.wayfair.app.couponfinder;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   23-03-2025
    Time:   05:53 pm
*/

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CouponDiscount {

    class Coupon {
        String couponName;
        LocalDate dateModified;
        String discount;

        public Coupon(String couponName, LocalDate dateModified, String discount) {
            this.couponName = couponName;
            this.dateModified = dateModified;
            this.discount = discount;
        }
    }

    Map<String, String> categoryToParentMap = new HashMap<>();
    Map<String, PriorityQueue<Coupon>> categoryToCouponsMap = new HashMap<>();
    Map<String, Coupon> resolvedCategoryToCouponMap = new HashMap<>();
    Map<String, Double> productToPriceMap = new HashMap<>();
    Map<String, String> productToCategoryMap = new HashMap<>();

    public CouponDiscount(String[][] coupons, String[][] categories, String[][] products) {
        loadCategories(categories);
        loadCoupons(coupons);
        loadProducts(products);
        preComputeBestCoupons(); // ✅ Pre-compute best coupon at setup
    }

    private void preComputeBestCoupons() {
        for (String category : categoryToCouponsMap.keySet()) {
            findAndCacheBestCoupon(category);
        }
    }

    private void findAndCacheBestCoupon(String category) {
        if (resolvedCategoryToCouponMap.containsKey(category)) {
            return;
        }
        // Try to find a coupon in the current category
        if (categoryToCouponsMap.containsKey(category) && !categoryToCouponsMap.get(category).isEmpty()) {
            resolvedCategoryToCouponMap.put(category, categoryToCouponsMap.get(category).peek());
            return;
        }
        // Try to inherit from parent
        String parentCategory = categoryToParentMap.get(category);
        if (parentCategory != null) {
            findAndCacheBestCoupon(parentCategory);
            if (resolvedCategoryToCouponMap.containsKey(parentCategory)) {
                resolvedCategoryToCouponMap.put(category, resolvedCategoryToCouponMap.get(parentCategory));
            }
        }
    }

    // ✅ O(1) Lookup to find best coupon
    public String findBestCoupon(String category) {
        Coupon coupon = resolvedCategoryToCouponMap.get(category);
        return coupon == null ? null : coupon.couponName;
    }

    // ✅ New Method: Compute final price after applying discount
    public String applyCoupon(String productName) {
        if (!productToCategoryMap.containsKey(productName)) {
            return "Product not found !";
        }
        double originalPrice = productToPriceMap.get(productName);
        String category = productToCategoryMap.get(productName);
        Coupon coupon = resolvedCategoryToCouponMap.get(category);
        if (coupon == null) {
            return String.format("%.2f", originalPrice);
        }
        double finalPrice = originalPrice;
        if (coupon.discount.endsWith("%")) {
            // Percentage Discount
            double percent = Double.parseDouble(coupon.discount.replace("%", ""));
            finalPrice = originalPrice * (1 - percent / 100);
        } else {
            //  Fixed Discount
            double fixedDiscount = Double.parseDouble(coupon.discount.replace("$", ""));
            finalPrice = Math.max(0, originalPrice - fixedDiscount);
        }
        return String.format("%.2f", finalPrice);
    }

    private void loadProducts(String[][] products) {
        for (String[] product : products) {
            String productName = product[0];
            Double price = Double.parseDouble(product[1]);
            String category = product[2];
            productToPriceMap.put(productName, price);
            productToCategoryMap.put(productName, category);
        }
    }

    private void loadCoupons(String[][] coupons) {
        for (String[] coupon : coupons) {
            String category = coupon[0];
            String couponName = coupon[1];
            String dateModified = coupon[2];
            String discount = coupon[3];

            LocalDate date = LocalDate.parse(dateModified);
            if (date.isAfter(LocalDate.now())) {
                continue;
            }
            categoryToCouponsMap
                    .computeIfAbsent(category, k -> new PriorityQueue<>(
                            (a, b) -> b.dateModified.compareTo(a.dateModified)
                    ))
                    .add(new Coupon(couponName, date, discount));
        }
    }

    private void loadCategories(String[][] categories) {
        for (String[] category : categories) {
            categoryToParentMap.put(category[0], category[1]);
        }
    }

    public static void main(String[] args) {
        // Input Data
        String[][] coupons = {
                {"Comforter Sets", "Comforters Sale", "2020-01-01", "10%"},
                {"Comforter Sets", "Cozy Comforter Coupon", "2020-01-01", "$15"},
                {"Bedding", "Best Bedding Bargains", "2019-01-01", "35%"},
                {"Bedding", "Savings on Bedding", "2019-01-01", "25%"},
                {"Bed & Bath", "Low price for Bed & Bath", "2018-01-01", "50%"},
                {"Bed & Bath", "Bed & Bath extravaganza", "2019-01-01", "75%"}
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

        String[][] products = {
                {"Cozy Comforter Sets", "100.00", "Comforter Sets"},
                {"All-in-one Bedding Set", "50.00", "Bedding"},
                {"Infinite Soap Dispenser", "500.00", "Bathroom Accessories"},
                {"Rainbow Toy Box", "257.00", "Baby And Kids"}
        };

        // Initialize Finder
        CouponDiscount finder = new CouponDiscount(coupons, categories, products);

        // ✅ Test Cases
        System.out.println(finder.applyCoupon("Cozy Comforter Sets")); // 90.00 OR 85.00
        System.out.println(finder.applyCoupon("All-in-one Bedding Set")); // 32.50 OR 37.50
        System.out.println(finder.applyCoupon("Infinite Soap Dispenser")); // 125.00
        System.out.println(finder.applyCoupon("Rainbow Toy Box")); // 257.00
    }
}
