package com.leetcode.companies.wayfair.app.order;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   23-03-2025
    Time:   10:08 am
*/

public class Main {
    public static void main(String[] args) {
        IOrderSystem orderSystem = new OrderSystem();
        IOrder pizza = new Order("Pizza", 40.0);
        IOrder sandwich = new Order("Sandwich", 30.0);
        orderSystem.addToCart(pizza);
        orderSystem.addToCart(pizza);
        orderSystem.addToCart(sandwich);
        System.out.println("Cart Items: " + orderSystem.cartItems());
        System.out.println("Total amount: " + orderSystem.calculateTotalAmount());
        System.out.println("Category discount: " + orderSystem.categoryDiscounts());
    }
}
