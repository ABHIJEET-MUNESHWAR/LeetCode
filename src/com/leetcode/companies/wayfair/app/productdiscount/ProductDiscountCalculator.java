package com.leetcode.companies.wayfair.app.productdiscount;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    27/07/24,
 * Time:    3:52 pm
 */

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

public class ProductDiscountCalculator {
    static CouponManager couponManager;
    static ProductDiscountManager productDiscountManager;

    public static void main(String[] args) {
        List<Category> categories = Arrays.asList(new Category("Baby And Kids", null),
            new Category("Toy Organizers", "Baby And Kids"), new Category("Bathroom Accessories", "Bed & Bath"),
            new Category("Soap Dispensers", "Bathroom Accessories"), new Category("Bed & Bath", null),
            new Category("Bedding", "Bed & Bath"), new Category("Comforter Sets", "Bedding"));
        List<Coupon> coupones = Arrays.asList(new Coupon("Comforter Sets", "Comforters Sale"),
            new Coupon("Bedding", "Savings on Bedding"), new Coupon("Bed & Bath", "Low price for Bed & Bath"));
        couponManager = new CouponManager(coupones, categories);
        testCase(1);

        coupones = Arrays.asList(new Coupon("Comforter Sets", "Comforters Sale", "2020-01-01"),
            new Coupon("Comforter Sets", "Cozy Comforter Coupon", "2020-01-01"),
            new Coupon("Bedding", "Best Bedding Bargains", "2019-01-01"),
            new Coupon("Bedding", "Savings on Bedding", "2025-01-01"),
            new Coupon("Bedding", "Savings on Bedding", "2019-01-01"),
            new Coupon("Bedding", "Savings on Bedding", "2017-01-01"),
            new Coupon("Bed & Bath", "Low price for Bed & Bath", "2018-01-01"),
            new Coupon("Bed & Bath", "Bed & Bath extravaganza", "2019-01-01"));
        couponManager = new CouponManager(coupones, categories);
        testCase(2);

        coupones = Arrays.asList(new Coupon("Comforter Sets", "Comforters Sale", "2020-01-01", "10%"),
            new Coupon("Comforter Sets", "Cozy Comforter Coupon", "2020-01-01", "$15"),
            new Coupon("Bedding", "Best Bedding Bargains", "2019-01-01", "35%"),
            new Coupon("Bedding", "Savings on Bedding", "2019-01-01", "25%"),
            new Coupon("Bed & Bath", "Low price for Bed & Bath", "2018-01-01", "50%"),
            new Coupon("Bed & Bath", "Bed & Bath extravaganza", "2019-01-01", "75%"));
        couponManager = new CouponManager(coupones, categories);
        List<Product> products = Arrays.asList(new Product("Cozy Comforter", "100.00", "Comforter Sets"),
            new Product("All-in-one Bedding Set", "50.00", "Bedding"),
            new Product("Infinite Soap Dispenser", "500.00", "Bathroom Accessories"),
            new Product("Rainbow Toy Box", "257.00", "Baby And Kids"));
        productDiscountManager = new ProductDiscountManager(products, couponManager);
        testCase3();
    }

    static void testCase(int id) {
        System.out.println(couponManager.getCoupon("Comforter Sets")); // Comforters Sale
        System.out.println(couponManager.getCoupon("Bedding")); // Savings on Bedding
        System.out.println(couponManager.getCoupon("Bathroom Accessories")); // "Low price for Bed & Bath"
        System.out.println(couponManager.getCoupon("Soap Dispensers")); // Low price for Bed & Bath
        System.out.println(couponManager.getCoupon("Toy Organizers")); // ""
        System.out.println(couponManager.getCoupon("Baby And Kids")); // ""
        System.out.println();
        System.out.println("Test Case " + id + " passed");
        System.out.println();
    }

    static void testCase3() {
        System.out.println(productDiscountManager.getDiscountPrice("Cozy Comforter")); // 90.00 OR 85.00
        System.out.println(productDiscountManager.getDiscountPrice("All-in-one Bedding Set")); // 32.50 OR 37.50
        System.out.println(productDiscountManager.getDiscountPrice("Infinite Soap Dispenser")); // 125.00
        System.out.println(productDiscountManager.getDiscountPrice("Rainbow Toy Box")); // 257.00
        System.out.println();
        System.out.println("Test Case 3 passed");
        System.out.println();
    }

}

class ProductDiscountManager {

    List<Product> products;
    Map<String, Product> productDetailMap = new HashMap<>();
    Map<String, String> productToDiscountCache = new HashMap<>();
    CouponManager couponManager;

    public ProductDiscountManager(List<Product> products, CouponManager couponManager) {
        this.products = products;
        this.couponManager = couponManager;
        productDetailMap = products.stream().collect(Collectors.toMap(product -> product.name, product -> product));
        productToDiscountCache.clear();
        precomputeProductDiscount();
    }

    private void precomputeProductDiscount() {
        for (Product product : products) {
            productToDiscountCache.put(product.name, getDiscountPrice(product.name));
        }
    }

    String getDiscountPrice(String productName) {
        if (productName == null || !productDetailMap.containsKey(productName)) {
            throw new IllegalArgumentException("Product Name is either null or product doesn't exist");
        }
        return productToDiscountCache.computeIfAbsent(productName, x -> {
            Product product = productDetailMap.get(productName);
            List<Coupon> coupons = couponManager.getCoupons(product.categoryName);
            List<String> discounts = coupons.stream().map(coupon -> coupon.discount).collect(Collectors.toList());
            if (discounts.isEmpty()) {
                return product.price;
            }
            List<String> discountedPrice = new ArrayList<>();
            for (String discount : discounts) {
                DiscountStrategy strategy = DiscountStrategyFactory.getDiscountStrategy(discount);
                discountedPrice.add(strategy.calculateDiscount(product.price));
            }
            return String.join(" OR ", discountedPrice);
        });
    }
}

class DiscountStrategyFactory {

    public static DiscountStrategy getDiscountStrategy(String discount) {
        if (discount.contains("$")) {
            return new AbsoluteDiscountStrategy(discount.replace("$", ""));
        }
        if (discount.contains("%")) {
            return new PercentDiscountStrategy(discount.replace("%", ""));
        }
        throw new IllegalArgumentException("Invalid discount type " + discount);
    }
}

interface DiscountStrategy {
    public String calculateDiscount(String price);
}

class AbsoluteDiscountStrategy implements DiscountStrategy {
    Double discount;

    public AbsoluteDiscountStrategy(String discount) {
        this.discount = Double.parseDouble(discount);
    }

    public String calculateDiscount(String originalPrice) {
        Double price = Double.parseDouble(originalPrice);
        return String.format("%.2f", price - discount);
    }
}

class PercentDiscountStrategy implements DiscountStrategy {
    Double discount;

    public PercentDiscountStrategy(String discount) {
        this.discount = Double.parseDouble(discount);
    }

    public String calculateDiscount(String originalPrice) {
        Double price = Double.parseDouble(originalPrice);
        return String.format("%.2f", price * (1 - discount / 100.0));
    }
}

class Product {
    String name;
    String categoryName;
    String price;

    Product(String name, String price, String categoryName) {
        this.name = name;
        this.categoryName = categoryName;
        this.price = price;
    }
}

class CouponManager {

    List<Coupon> coupons;
    List<Category> categories;
    Map<String, List<Coupon>> categoryToCoupons = new HashMap<>();
    Map<String, String> categoryToParentCategory = new HashMap<>();

    CouponManager(List<Coupon> coupons, List<Category> categories) {
        this.categories = categories;
        this.coupons = coupons;

        buildCategoryToParentCategoryMap();
        buildCategoryToCoupons();
        precomputeCoupons();
    }

    public List<Coupon> getCoupons(String categoryName) {
        return categoryToCoupons.getOrDefault(categoryName, new ArrayList<>());
    }

    public String getCoupon(String categoryName) {
        List<String> coupons = categoryToCoupons.getOrDefault(categoryName, new ArrayList<>())
            .stream()
            .map(coupon -> coupon.name)
            .collect(Collectors.toList());
        return String.join(" | ", coupons.isEmpty() ? new ArrayList<>(Arrays.asList("No Coupon Available")) : coupons);
    }

    private void precomputeCoupons() {
        for (Category category : categories) {
            resolveCouponUtils(category.name);
        }
    }

    private List<Coupon> resolveCouponUtils(String categoryName) {
        if (categoryName == null || categoryName.isEmpty() || !categoryToParentCategory.containsKey(categoryName)) {
            return new ArrayList<>();
        }
        if (categoryToCoupons.containsKey(categoryName)) {
            return categoryToCoupons.get(categoryName);
        }
        List<Coupon> coupons = resolveCouponUtils(categoryToParentCategory.get(categoryName));
        categoryToCoupons.put(categoryName, coupons);
        return coupons;

    }

    private void buildCategoryToCoupons() {
        Map<String, Deque<Coupon>> validCategoryToCouponsMap = new HashMap<>();
        LocalDate today = LocalDate.now();
        for (Coupon coupon : coupons) {
            if (coupon.modifiedAt.isAfter(today)) {
                continue;
            }
            Deque<Coupon> existingCoupons = validCategoryToCouponsMap.getOrDefault(coupon.categoryName, new LinkedList<Coupon>());
            while (!existingCoupons.isEmpty() && existingCoupons.peekLast().modifiedAt.isBefore(coupon.modifiedAt)) {
                existingCoupons.pollLast();
            }
            if (existingCoupons.isEmpty() || existingCoupons.peekLast().modifiedAt.isEqual(coupon.modifiedAt)) {
                existingCoupons.add(coupon);
            }
            validCategoryToCouponsMap.put(coupon.categoryName, existingCoupons);
        }

        for (Map.Entry<String, Deque<Coupon>> entry : validCategoryToCouponsMap.entrySet()) {
            categoryToCoupons.put(entry.getKey(), entry.getValue().stream().collect(Collectors.toList()));
        }
    }

    private void buildCategoryToParentCategoryMap() {
        for (Category category : categories) {
            categoryToParentCategory.put(category.name, category.categoryParentName);
        }
    }
}

class Category {
    String name;
    String categoryParentName;

    Category(String name, String categoryParentName) {
        this.name = name;
        this.categoryParentName = categoryParentName;
    }
}

class Coupon {
    String name;
    String categoryName;
    LocalDate modifiedAt = LocalDate.now();
    String discount;

    Coupon(String categoryName, String name) {
        this.name = name;
        this.categoryName = categoryName;
    }

    Coupon(String categoryName, String name, String modifiedAt) {
        this(categoryName, name);
        this.modifiedAt = LocalDate.parse(modifiedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    Coupon(String categoryName, String name, String modifiedAt, String discount) {
        this(categoryName, name, modifiedAt);
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name + " " + modifiedAt.toString();
    }
}