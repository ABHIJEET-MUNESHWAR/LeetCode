package com.leetcode.companies.adyen.one.cheapestbankroute;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   07-05-2025
    Time:   11:58 am
*/

import java.util.*;

public class CheapestBankRoute {
    public static int getCheapestRouteCost(String destination, List<BankRoute> routes, int max) {
        // Step 1: Build graph
        Map<String, List<BankRoute>> graph = new HashMap<>();
        for (BankRoute route : routes) {
            graph.computeIfAbsent(route.getSource(), k -> new ArrayList<>()).add(route);
        }
        // Step 2: Min-heap priority queue based on cost
        PriorityQueue<RoutesState> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new RoutesState("Adyen", 0, 0));

        // Step 3: Visited map to store best cost for each (bank, intermediaries)
        Map<String, Map<Integer, Integer>> visitedMap = new HashMap<>();

        while (!pq.isEmpty()) {
            RoutesState current = pq.poll();

            // If destination reached within allowed intermediaries, return the cost
            String currentBank = current.currentBank;
            if (currentBank.equals(destination)) {
                return current.cost;
            }

            if (!graph.containsKey(currentBank)) {
                continue;
            }

            for (BankRoute bankRoute : graph.get(currentBank)) {
                String nextBank = bankRoute.getDestination();
                int newCost = current.cost + bankRoute.getCost();
                int nextIntermediaries = current.intermediaries + 1;
                if (nextIntermediaries <= max + 1) {
                    // Only consider if this (bank, intermediaries) pair is either unseen or better
                    Map<Integer, Integer> bankMap = visitedMap.getOrDefault(nextBank, new HashMap<>());
                    if (!bankMap.containsKey(nextIntermediaries) || bankMap.get(nextIntermediaries) > newCost) {
                        bankMap.put(nextIntermediaries, newCost);
                        visitedMap.put(nextBank, bankMap);
                        pq.offer(new RoutesState(nextBank, newCost, nextIntermediaries));
                    }
                }
            }
        }
        return -1;
    }
}
