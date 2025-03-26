package com.leetcode.companies.wayfair.lld.bikerental.src.repository;

import com.leetcode.companies.wayfair.lld.bikerental.src.model.Bike;
import com.leetcode.companies.wayfair.lld.bikerental.src.model.BikeSize;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long>{
    @Query("select count(b) from Bike b where b.size=:size and b.vehicle.isAvailable=true")
    int countBySize(@param("size")BikeSize size);
}
