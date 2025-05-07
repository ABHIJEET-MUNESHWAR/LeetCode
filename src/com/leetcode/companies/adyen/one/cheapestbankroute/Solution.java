package com.leetcode.companies.adyen.one.cheapestbankroute;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   07-05-2025
    Time:   11:58 am
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
🟠 Cheapest bank route

Description

International bank transfers can sometimes be very complicated with Adyen's money going through multiple intermediary banks (each taking a cut) before they reach their destination. Since Adyen executes a lot of transfers - it's worthwhile to find the cheapest routes. At the same time - we don't want the transfer to go through too many intermediaries as that may cause delays.

Given a destination bank, list of routes including costs and a maximum number of intermediary banks - return the cost of the cheapest route between Adyen and the destination bank or -1 if no such route exists.

Example test case:

We want to find a route to Chase, with at most 1 intermediary bank. The available routes are as follows:
Adyen to BoA with a cost of 10
BoA to Wells with a cost of 10
Wells to Adyen with a cost of 10
BoA to Chase with a cost of 60
Wells to Chase with a cost of 20

There's 2 routes to Chase - Adyen to BoA to Wells to Chase (10+10+20=40) and Adyen to BoA to Chase (10+60=70).
The first route is cheaper, but goes through 2 intermediary banks; the cheapest route going through no more than 1 intermediary is therefore the second one, with a cost of 70.

Input:
Chase
1
4
Adyen-BoA-10
BoA-Chase-60
BoA-Wells-10
Wells-Chase-20
 */

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());
        int routesCount = Integer.parseInt(scanner.nextLine());
        List<BankRoute> bankRoutes = new ArrayList<>(routesCount);
        for (int i = 0; i < routesCount; i++) {
            String[] line = scanner.nextLine().split("-");
            BankRoute route = new SampleBankRouteImpl(line[0], line[1], Integer.parseInt(line[2]));
            bankRoutes.add(route);
        }
        int cost = CheapestBankRoute.getCheapestRouteCost(destination, bankRoutes, k);
        System.out.println(cost);
    }
}
