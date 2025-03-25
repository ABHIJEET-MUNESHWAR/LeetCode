package com.leetcode.companies.wayfair.app.Cargo;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/07/24,
 * Time:    5:02 pm
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CargoCalculator {

    enum PackageType {
        Standard, Fragile, Hazardous;
    }

    class Package {
        private int distance;
        private String id;
        private PackageType packageType;
        private Integer packageWeight;
        private Double volume;

        double totalSpace = 0.0;
        double transportationCost = 0.0;
        double serviceCharges = 0.0;

        public Package(Integer distance, String id, PackageType packageType, Integer packageWeight, Double volume) {
            this.id = id;
            this.packageType = packageType;
            this.packageWeight = packageWeight;
            this.volume = volume;

            switch (packageType) {
                case Standard:
                    transportationCost += 0.05 * volume;
                    serviceCharges += distance * 0.5 + packageWeight * 0.5;
                    totalSpace += volume * 1.2;
                    break;
                case Fragile:
                    transportationCost += 0.07 * volume;
                    serviceCharges += distance * 0.75 + packageWeight * 0.75;
                    totalSpace += volume * 1.5;
                    break;
                case Hazardous:
                    transportationCost += 0.06 * volume;
                    serviceCharges += distance * 0.625 + packageWeight * 0.625;
                    totalSpace += volume * 1.25;
                    break;
            }
        }

        public Double getTransportationCost() {
            return this.transportationCost;
        }

        public Double getServiceCharges() {
            return this.serviceCharges;
        }

        public Double getTotalSpace() {
            return this.totalSpace;
        }
    }

    class Volume {
        private Integer packageLength;
        private Integer packageWidth;
        private Integer packageHeight;

        public Volume(Integer packageLength, Integer packageWidth, Integer packageHeight) {
            this.packageLength = packageLength;
            this.packageWidth = packageWidth;
            this.packageHeight = packageHeight;
        }

        public Integer getVolume() {
            return this.packageHeight * this.packageLength * this.packageWidth;
        }
    }

    // For each package in packages, String Array contains following values... Id, Type, Weight, Length, Width, and Height
    public static Map<String, Double> cargoSpaceAndCost(int distance, List<String[]> packages) {
        if (distance <= 0 || packages == null || packages.size() == 0) {
            return new HashMap<>();
        }
        Map<String, Double> results = new HashMap<>();

        // Placeholder, replace with calculated values
        double totalSpace = 0.0;
        double transportationCost = 0.0;
        double serviceCharges = 0.0;
        double totalCost = 0.0;
        for (String[] packageItem : packages) {
            String packageId = packageItem[0];
            String packageType = packageItem[1];
            Integer packageWeight = Integer.parseInt(packageItem[2]);
            Integer packageLength = Integer.parseInt(packageItem[3]);
            Integer packageWidth = Integer.parseInt(packageItem[4]);
            Integer packageHeight = Integer.parseInt(packageItem[5]);
            CargoCalculator cargoCalculator = new CargoCalculator();
            Volume volumeObj = cargoCalculator.new Volume(packageLength, packageWidth, packageHeight);
            double volume = volumeObj.getVolume();
            Package packageObj = cargoCalculator.new Package(distance, packageId, PackageType.valueOf(packageType), packageWeight, volume);

            transportationCost += packageObj.getTransportationCost();
            serviceCharges += packageObj.getServiceCharges();
            totalSpace += packageObj.getTotalSpace();
        }
        totalCost += transportationCost + serviceCharges;

        results.put("Total Space", totalSpace);
        results.put("Transportation Cost", transportationCost);
        results.put("Service Charges", serviceCharges);
        results.put("Total Cost", totalCost);

        return results;
    }
}

public class CargoPackage {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(System.getenv("OUTPUT_PATH"), "UTF-8")) {

            int distance = Integer.parseInt(reader.readLine().trim());
            List<String[]> packages = new ArrayList<>();
            String packageStr;
            while ((packageStr = reader.readLine()) != null && !packageStr.isEmpty()) {
                packages.add(packageStr.trim().split(" "));
            }
            // Test 1: with empty input
            packages = new ArrayList<>();
            distance = 0;
            Map<String, Double> results = CargoCalculator.cargoSpaceAndCost(distance, packages);
            if (results == null || results.isEmpty()) {
                System.out.println("Please provide valid input.");
            }
            // Test 2: validate logic to calculate volume
            CargoCalculator calculator = new CargoCalculator();
            CargoCalculator.Volume volume = calculator.new Volume(1, 2, 3);
            Integer calculatedColume = volume.getVolume();
            System.out.println("Volume is: " + calculatedColume);

            //

            writer.printf("%s%.1f%n", "Total Space: ", results.get("Total Space"));
            writer.printf("%s%.2f%n", "Transportation Cost: ", results.get("Transportation Cost"));
            writer.printf("%s%.2f%n", "Service Charges: ", results.get("Service Charges"));
            writer.printf("%s%.2f%n", "Total Cost: ", results.get("Total Cost"));

/*
            for (Map.Entry<String, Double> result : results.entrySet()) {
                writer.printf("%s: %.2f%n", result.getKey(), result.getValue());
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}