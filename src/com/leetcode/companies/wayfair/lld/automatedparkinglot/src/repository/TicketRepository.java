package com.leetcode.companies.wayfair.lld.automatedparkinglot.src.repository;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   26-03-2025
    Time:   10:48 am
*/

import com.leetcode.companies.wayfair.lld.automatedparkinglot.src.model.Ticket;

import java.util.Optional;

@Repository
public class TicketRepository extends JpaRepository<Ticket, Long>{
    Optional<Ticket> findByTicketId(Long ticketId);
}
