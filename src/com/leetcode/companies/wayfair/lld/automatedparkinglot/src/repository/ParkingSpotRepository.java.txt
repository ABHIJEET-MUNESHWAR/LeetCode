package com.leetcode.companies.wayfair.lld.automatedparkinglot.src.repository;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   26-03-2025
    Time:   10:46 am
*/

import com.leetcode.companies.wayfair.lld.automatedparkinglot.src.model.ParkingSpot;
import com.leetcode.companies.wayfair.lld.automatedparkinglot.src.model.VehicleSize;

import java.util.Optional;

@Repository
public interface ParkingSpotRepository extends JPARepository<ParkingSpot, Long> {
    Optional<ParkingSpot> findFirstBySizeAndIsOccupiedFalse(VehicleSize size);

    @Query(value="select SpotSize, count(*) from ParkingSpot where isAvailable=true groupBy SpotSize", isNative=true)
    Optional<Object[]> getVacantSpots();
}
