package com.leetcode.companies.wayfair.lld.automatedparkinglot.src.service;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   26-03-2025
    Time:   10:52 am
*/

import com.leetcode.companies.wayfair.lld.automatedparkinglot.src.model.ParkingSpot;
import com.leetcode.companies.wayfair.lld.automatedparkinglot.src.model.Ticket;
import com.leetcode.companies.wayfair.lld.automatedparkinglot.src.model.VacantSpot;
import com.leetcode.companies.wayfair.lld.automatedparkinglot.src.model.Vehicle;
import com.leetcode.companies.wayfair.lld.automatedparkinglot.src.repository.ParkingSpotRepository;
import com.leetcode.companies.wayfair.lld.automatedparkinglot.src.repository.TicketRepository;
import com.leetcode.companies.wayfair.lld.automatedparkinglot.src.repository.VehicleRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ParkingService {
    private ParkingSpotRepository parkingSpotRepository;
    private VehicleRepository vehicleRepository;
    private TicketRepository ticketRepository;

    public ParkingService(ParkingSpotRepository parkingSpotRepository,
                          VehicleRepository vehicleRepository,
                          TicketRepository ticketRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        Optional<ParkingSpot> availableSpot = parkingSpotRepository.findFirstBySizeAndIsOccupiedFalse(vehicle.getVehicleSize());
        if (availableSpot.isPresent()) {
            ParkingSpot parkingSpot = availableSpot.get();
            parkingSpot.setAvailable(false);
            parkingSpotRepository.save(parkingSpot);
            Ticket ticket = new Ticket();
            ticket.setEntryTime(LocalDateTime.now());
            ticket.setVehicleId(vehicle.getId());
            ticket.setSpotId(parkingSpot.getId());
            ticketRepository.save(ticket);
            return ticket;
        }
        return null;
    }

    public Integer retrieveVehicle(Long ticketId) {
        Ticket ticket = ticketRepository.findByTicketId(ticketId);
        ParkingSpot parkingSpot = parkingSpotRepository.findById(ticket.getSpotId());
        parkingSpot.setAvailable(true);
        parkingSpotRepository.save(parkingSpot);
        ticket.setExitTime(LocalDateTime.now());
        ticketRepository.save(ticket);
        int timeDiff = ticket.getEntryTime().compareTo(ticket.getExitTime());
        int amount = timeDiff * 10;
        return amount;
    }

    public VacantSpot getVacantSpots() {
        Optional<Object[]> vacantSpots = parkingSpotRepository.getVacantSpots();
        if (vacantSpots.isPresent()) {
            Object[] vacantSpotsList = vacantSpots.get();
            VacantSpot vacantSpot = new VacantSpot(vacantSpotsList[0], vacantSpotsList[1], vacantSpotsList[2]);
        }
    }
}
