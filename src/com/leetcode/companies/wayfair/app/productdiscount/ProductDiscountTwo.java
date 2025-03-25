package com.leetcode.companies.wayfair.app.productdiscount;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    27/07/24,
 * Time:    6:22 pm
 */
public class ProductDiscountTwo {
    class Coupon {
        private String couponName;
        private String categoryName;
        private LocalDate modifiedAt = LocalDate.now();

        public Coupon(String categoryName, String couponName, String modifiedAt) {
            this.couponName = couponName;
            this.categoryName = categoryName;
            this.modifiedAt = LocalDate.parse(modifiedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
    }

    class Category {
        private String categoryName;
        private String parentCategoryName;

        public Category(String categoryName, String parentCategoryName) {
            this.categoryName = categoryName;
            this.parentCategoryName = parentCategoryName;
        }
    }

    class CouponManager {
        private List<Coupon> coupons;
        private List<Category> categories;

        Map<String, List<Coupon>> categoryToCouponMap = new HashMap<>();
        Map<String, String> categoryToParentCategoryMap = new HashMap<>();

        public CouponManager(List<Coupon> coupons, List<Category> categories) {
            this.coupons = coupons;
            this.categories = categories;
            buildCategoryToParentCategoryMap();
            buildCategoryToCouponMap();
            preComputeCategoryToCouponMap();
        }


        private void buildCategoryToParentCategoryMap() {
            for (Category category : categories) {
                categoryToParentCategoryMap.put(category.categoryName, category.parentCategoryName);
            }
        }

        private void buildCategoryToCouponMap() {
            Map<String, Deque<Coupon>> validCategoryToCouponMap = new HashMap<>();
            LocalDate today = LocalDate.now();
            for (Coupon coupon : coupons) {
                if (coupon.modifiedAt.isAfter(today)) {
                    continue;
                }
                Deque<Coupon> existingCouponsDeque = validCategoryToCouponMap.getOrDefault(coupon.categoryName, new LinkedList<>());
                while (!existingCouponsDeque.isEmpty() && existingCouponsDeque.peekLast().modifiedAt.isBefore(coupon.modifiedAt)) {
                    existingCouponsDeque.pollLast();
                }
                if (existingCouponsDeque.isEmpty() || existingCouponsDeque.peekLast().modifiedAt.isEqual(coupon.modifiedAt)) {
                    existingCouponsDeque.add(coupon);
                }
                validCategoryToCouponMap.put(coupon.categoryName, existingCouponsDeque);
            }
            for (Map.Entry<String, Deque<Coupon>> entry : validCategoryToCouponMap.entrySet()) {
                categoryToCouponMap.put(entry.getKey(), entry.getValue().stream().collect(Collectors.toList()));
            }
        }

        private void preComputeCategoryToCouponMap() {
            for (Category category : categories) {
                computeCategoryToCoupon(category.categoryName);
            }
        }

        private List<Coupon> computeCategoryToCoupon(String categoryName) {
            if (categoryName == null || categoryName.isEmpty() || !categoryToParentCategoryMap.containsKey(categoryName)) {
                return new ArrayList<>();
            }
            if (categoryToCouponMap.containsKey(categoryName)) {
                return categoryToCouponMap.get(categoryName);
            }
            List<Coupon> coupons = computeCategoryToCoupon(categoryToParentCategoryMap.get(categoryName));
            categoryToCouponMap.put(categoryName, coupons);
            return coupons;
        }

        public String getCoupon(String categoryName) {
            List<String> couponNames = categoryToCouponMap.getOrDefault(categoryName, new ArrayList<>())
                .stream()
                .map(coupon -> coupon.couponName)
                .collect(Collectors.toList());
            return String.join(" | ", couponNames.isEmpty() ? new ArrayList<>(Arrays.asList("null")) : couponNames);
        }
    }

    public static void main(String[] args) {
        ProductDiscountTwo productDiscountOne = new ProductDiscountTwo();
        productDiscountOne.secondCase();
    }

    private void secondCase() {
        List<Category> categories = Arrays.asList(new Category("Baby And Kids", null),
            new Category("Toy Organizers", "Baby And Kids"), new Category("Bathroom Accessories", "Bed & Bath"),
            new Category("Soap Dispensers", "Bathroom Accessories"), new Category("Bed & Bath", null),
            new Category("Bedding", "Bed & Bath"), new Category("Comforter Sets", "Bedding"));

        List<Coupon> coupones = Arrays.asList(new Coupon("Comforter Sets", "Comforters Sale", "2020-01-01"),
            new Coupon("Comforter Sets", "Cozy Comforter Coupon", "2020-01-01"),
            new Coupon("Bedding", "Best Bedding Bargains", "2019-01-01"),
            new Coupon("Bedding", "Savings on Bedding", "2025-01-01"),
            new Coupon("Bedding", "Savings on Bedding", "2019-01-01"),
            new Coupon("Bedding", "Savings on Bedding", "2017-01-01"),
            new Coupon("Bed & Bath", "Low price for Bed & Bath", "2018-01-01"),
            new Coupon("Bed & Bath", "Bed & Bath extravaganza", "2019-01-01"));

        CouponManager couponManager = new CouponManager(coupones, categories);

        System.out.println(couponManager.getCoupon("Bed & Bath")); // Comforters Sale
        System.out.println(couponManager.getCoupon("Bedding")); // Savings on Bedding
        System.out.println(couponManager.getCoupon("Bathroom Accessories")); // "Low price for Bed & Bath"
        System.out.println(couponManager.getCoupon("Comforter Sets")); // ""
        System.out.println();
    }
}