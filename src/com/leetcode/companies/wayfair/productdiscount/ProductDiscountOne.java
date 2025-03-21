package com.leetcode.companies.wayfair.productdiscount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    27/07/24,
 * Time:    6:22 pm
 */
public class ProductDiscountOne {
    class Coupon {
        private String couponName;
        private String categoryName;

        public Coupon(String categoryName, String couponName) {
            this.couponName = couponName;
            this.categoryName = categoryName;
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
            for (Coupon coupon : coupons) {
                categoryToCouponMap.computeIfAbsent(coupon.categoryName, key -> new ArrayList<>()).add(coupon);
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
        ProductDiscountOne productDiscountOne = new ProductDiscountOne();
        productDiscountOne.firstCase();
    }

    private void firstCase() {
        List<Category> categories = Arrays.asList(new Category("Baby And Kids", null),
            new Category("Toy Organizers", "Baby And Kids"), new Category("Bathroom Accessories", "Bed & Bath"),
            new Category("Soap Dispensers", "Bathroom Accessories"), new Category("Bed & Bath", null),
            new Category("Bedding", "Bed & Bath"), new Category("Comforter Sets", "Bedding"));
        List<Coupon> coupones = Arrays.asList(new Coupon("Comforter Sets", "Comforters Sale"),
            new Coupon("Bedding", "Savings on Bedding"), new Coupon("Bed & Bath", "Low price for Bed & Bath"));
        CouponManager couponManager = new CouponManager(coupones, categories);

        System.out.println(couponManager.getCoupon("Comforter Sets")); // Comforters Sale
        System.out.println(couponManager.getCoupon("Bedding")); // Savings on Bedding
        System.out.println(couponManager.getCoupon("Bathroom Accessories")); // "Low price for Bed & Bath"
        System.out.println(couponManager.getCoupon("Soap Dispensers")); // Low price for Bed & Bath
        System.out.println(couponManager.getCoupon("Toy Organizers")); // ""
        System.out.println();
    }
}