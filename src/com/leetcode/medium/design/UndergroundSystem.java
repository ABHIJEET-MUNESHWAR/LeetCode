package com.leetcode.medium.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    10/07/24,
 * Time:    8:33 pm
 * 1396. Design Underground System
 * https://leetcode.com/problems/design-underground-system/description/
 */
class Passenger {
  int checkInTime;
  int checkOutTime;
  String checkInLocation;
  String checkOutLocation;

  public Passenger(String checkInLocation, int checkInTime) {
    this.checkInLocation = checkInLocation;
    this.checkInTime = checkInTime;
  }

  void checkout(String checkOutLocation, int checkOutTime) {
    this.checkOutLocation = checkOutLocation;
    this.checkOutTime = checkOutTime;
  }
}

class Route {
  String startStation;
  String endStation;
  int totalNumberOfTrips;
  int totalTimeSpendInTrips;

  public Route(String startStation, String endStation) {
    this.startStation = startStation;
    this.endStation = endStation;
  }

  public double getAverageTime() {
    return (double) totalTimeSpendInTrips / totalNumberOfTrips;
  }

  public void addTrip(int startTime, int endTime) {
    totalTimeSpendInTrips += endTime - startTime;
    totalNumberOfTrips++;
  }
}

public class UndergroundSystem {
  Map<Integer, Passenger> currentPassengerMap;
  Map<String, Route> routeMap;

  public UndergroundSystem() {
    currentPassengerMap = new HashMap<>();
    routeMap = new HashMap<>();
  }

  public void checkIn(int id, String stationName, int t) {
    if (!currentPassengerMap.containsKey(id)) {
      Passenger passenger = new Passenger(stationName, t);
      currentPassengerMap.put(id, passenger);
    }
  }

  public void checkOut(int id, String stationName, int t) {
    if (currentPassengerMap.containsKey(id)) {
      Passenger passenger = currentPassengerMap.get(id);
      passenger.checkout(stationName, t);
      String routeKey = passenger.checkInLocation + "-" + passenger.checkOutLocation;
      Route route = routeMap.getOrDefault(routeKey, new Route(passenger.checkInLocation, passenger.checkOutLocation));
      route.addTrip(passenger.checkInTime, passenger.checkOutTime);
      routeMap.put(routeKey, route);
      currentPassengerMap.remove(id);
    }
  }

  public double getAverageTime(String startStation, String endStation) {
    return routeMap.get(startStation + "-" + endStation).getAverageTime();
  }
}