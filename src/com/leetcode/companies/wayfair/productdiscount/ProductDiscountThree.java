package com.leetcode.companies.wayfair.productdiscount;

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
public class ProductDiscountThree {
    class Coupon {
        private String couponName;
        private String categoryName;
        private LocalDate modifiedAt = LocalDate.now();
        String discount;

        public Coupon(String categoryName, String couponName, String modifiedAt, String discount) {
            this.couponName = couponName;
            this.categoryName = categoryName;
            this.modifiedAt = LocalDate.parse(modifiedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            this.discount = discount;
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

    class Product {
        private String productName;
        private String categoryName;
        private String price;

        public Product(String productName, String price, String categoryName) {
            this.productName = productName;
            this.categoryName = categoryName;
            this.price = price;
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

        public List<Coupon> getCoupons(String categoryName) {
            return categoryToCouponMap.getOrDefault(categoryName, new ArrayList<>());
        }
    }

    class ProductDiscountManager {
        List<Product> products;
        Map<String, Product> productNameToProductMap = new HashMap<>();
        Map<String, String> productToDiscountCache = new HashMap<>();
        CouponManager couponManager;

        public ProductDiscountManager(List<Product> products, CouponManager couponManager) {
            this.products = products;
            this.couponManager = couponManager;
            productNameToProductMap = products
                .stream()
                .collect(
                    Collectors.toMap(product -> product.productName, product -> product)
                );
            productToDiscountCache.clear();
            preComputeProductDiscount();
        }

        private void preComputeProductDiscount() {
            for (Product product : products) {
                productToDiscountCache.put(product.productName, getDiscountPrice(product.productName));
            }
        }

        private String getDiscountPrice(String productName) {
            if (productName == null || productName.isEmpty() || !productNameToProductMap.containsKey(productName)) {
                throw new IllegalArgumentException("Product Name is either null or product doesn't exist");
            }
            return productToDiscountCache.computeIfAbsent(productName, p -> {
                Product product = productNameToProductMap.get(productName);
                List<Coupon> coupons = couponManager.getCoupons(product.categoryName);
                List<String> discounts = coupons.stream().map(coupon -> coupon.discount).collect(Collectors.toList());
                if (discounts.isEmpty()) {
                    return product.price;
                }
                List<String> discountedPrice = new ArrayList<>();
                for (String discount : discounts) {
                    DiscountStrategyFactory discountStrategyFactory = new DiscountStrategyFactory();
                    DiscountStrategy discountStrategy = discountStrategyFactory.getDiscountStrategy(discount);
                    discountedPrice.add(discountStrategy.calculateDiscount(product.price));
                }
                return String.join(" OR ", discountedPrice);
            });
        }
    }

    class DiscountStrategyFactory {
        public DiscountStrategy getDiscountStrategy(String discount) {
            if (discount.contains("$")) {
                return new AbsoluteDiscountStrategy(discount.replace("$", ""));
            }
            if (discount.contains("%")) {
                return new PercentageDiscountStrategy(discount.replace("%", ""));
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

        @Override
        public String calculateDiscount(String originalPrice) {
            Double price = Double.parseDouble(originalPrice);
            return String.format("%.2f", price - discount);
        }
    }

    class PercentageDiscountStrategy implements DiscountStrategy {

        Double discount;

        public PercentageDiscountStrategy(String discount) {
            this.discount = Double.parseDouble(discount);
        }

        @Override
        public String calculateDiscount(String originalPrice) {
            Double price = Double.parseDouble(originalPrice);
            return String.format("%.2f", price * (1 - discount / 100));
        }
    }

    public static void main(String[] args) {
        ProductDiscountThree productDiscountOne = new ProductDiscountThree();
        productDiscountOne.thirdCase();
    }

    private void thirdCase() {
        List<Category> categories = Arrays.asList(new Category("Baby And Kids", null),
            new Category("Toy Organizers", "Baby And Kids"), new Category("Bathroom Accessories", "Bed & Bath"),
            new Category("Soap Dispensers", "Bathroom Accessories"), new Category("Bed & Bath", null),
            new Category("Bedding", "Bed & Bath"), new Category("Comforter Sets", "Bedding"));

        List<Coupon> coupones = Arrays.asList(new Coupon("Comforter Sets", "Comforters Sale", "2020-01-01", "10%"),
            new Coupon("Comforter Sets", "Cozy Comforter Coupon", "2020-01-01", "$15"),
            new Coupon("Bedding", "Best Bedding Bargains", "2019-01-01", "35%"),
            new Coupon("Bedding", "Savings on Bedding", "2019-01-01", "25%"),
            new Coupon("Bed & Bath", "Low price for Bed & Bath", "2018-01-01", "50%"),
            new Coupon("Bed & Bath", "Bed & Bath extravaganza", "2019-01-01", "75%"));

        CouponManager couponManager = new CouponManager(coupones, categories);
        List<Product> products = Arrays.asList(new Product("Cozy Comforter", "100.00", "Comforter Sets"),
            new Product("All-in-one Bedding Set", "50.00", "Bedding"),
            new Product("Infinite Soap Dispenser", "500.00", "Bathroom Accessories"),
            new Product("Rainbow Toy Box", "257.00", "Baby And Kids"));
        ProductDiscountManager productDiscountManager = new ProductDiscountManager(products, couponManager);

        System.out.println(productDiscountManager.getDiscountPrice("Cozy Comforter")); // 90.00 OR 85.00
        System.out.println(productDiscountManager.getDiscountPrice("All-in-one Bedding Set")); // 32.50 OR 37.50
        System.out.println(productDiscountManager.getDiscountPrice("Infinite Soap Dispenser")); // 125.00
        System.out.println(productDiscountManager.getDiscountPrice("Rainbow Toy Box")); // 257.00
        System.out.println();
    }
}