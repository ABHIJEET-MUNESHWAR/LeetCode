package com.leetcode.companies.wayfair.lld.bikerental.src.model;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   25-03-2025
    Time:   10:00 pm
*/

import java.time.LocalDateTime;

public class Rental {
    private Long id;
    private Long vehicleId;
    private Long customerId;
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
    private boolean isOverdue;
}