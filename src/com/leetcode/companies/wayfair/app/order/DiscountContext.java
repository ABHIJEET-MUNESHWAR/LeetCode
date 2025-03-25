package com.leetcode.companies.wayfair.app.order;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   22-03-2025
    Time:   10:46 pm
*/
// 3️⃣ Context (Manages Strategy Selection Dynamically)
public class DiscountContext {
    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double applyDiscount(Double price) {
        return discountStrategy.applyDiscount(price);
    }

    public DiscountStrategy determineDiscountStrategy(double price) {
        if (price <= 10) {
            return new CheapDiscountStrategy();
        } else if (price < 20) {
            return new ModerateDiscountStrategy();
        } else {
            return new ExpensiveDiscountStrategy();
        }
    }
}
