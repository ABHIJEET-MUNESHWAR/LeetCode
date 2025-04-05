package com.leetcode.companies.wayfair.lld.automatedparkinglot.src.controller;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   26-03-2025
    Time:   11:22 am
*/

import com.leetcode.companies.wayfair.lld.automatedparkinglot.src.model.Ticket;
import com.leetcode.companies.wayfair.lld.automatedparkinglot.src.model.VacantSpot;
import com.leetcode.companies.wayfair.lld.automatedparkinglot.src.model.Vehicle;
import com.leetcode.companies.wayfair.lld.automatedparkinglot.src.service.ParkingService;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    private ParkingService parkingService;
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }
    @PostMapping("/entry")
    public Ticket parkVehicle(@RequestBody Vehicle vehicle){
        Ticket ticket = parkingService.parkVehicle(vehicle);
        return ticket;
    }

    @PostMapping("/exit")
    public Integer retrieveVehicle(@RequestBody Long ticketId){
        return parkingService.retrieveVehicle(ticketId);
    }

    @PostMapping("/spots")
    public VacantSpot retrieveVacantSpots(){
        return parkingService.getVacantSpots();
    }
}
