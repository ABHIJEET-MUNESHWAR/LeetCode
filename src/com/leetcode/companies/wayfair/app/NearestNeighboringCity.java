package com.leetcode.companies.wayfair.app;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    12/07/24,
 * Time:    6:38 pm
 * Nearest Neighboring City
 * https://www.hackerrank.com/codepair/wzgmutotebjelhcjhqrdfosrnnlejzxa/questions/3?b=eyJpbnRlcnZpZXdfaWQiOjUxOTc5MzEsInJvbGUiOiJpbnRlcnZpZXdlciIsInNob3J0X3VybCI6Imh0dHBzOi8vaHIuZ3MvZTVjOTA4OCIsImNhbmRpZGF0ZV91cmwiOiJodHRwczovL2hyLmdzLzBjNGRkMjEifQ
 * https://leetcode.com/discuss/interview-question/949904/amazon-oa2-nearest-city
 */
public class NearestNeighboringCity {
    public static void main(String[] args) {
        NearestNeighboringCity nearestNeighboringCity = new NearestNeighboringCity();
        List<String> c = new ArrayList<>();
        c.add("london");
        c.add("warsaw");
        c.add("hackerland");
        List<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(10);
        x.add(20);
        List<Integer> y = new ArrayList<>();
        y.add(1);
        y.add(10);
        y.add(10);
        List<String> q = new ArrayList<>();
        q.add("london");
        q.add("warsaw");
        q.add("hackerland");
        ListUtils.printStringList(nearestNeighboringCity.closestStraightCity(c, x, y, q));
    }

    public List<String> closestStraightCity(List<String> c, List<Integer> x, List<Integer> y, List<String> q) {
        // Write your code here
        Map<Integer, PriorityQueue<String>> xCoOrdinateToCityNameMap = new HashMap<>();
        Map<Integer, PriorityQueue<String>> yCoOrdinateToCityNameMap = new HashMap<>();
        Map<String, int[]> cityNameToCoOrdinateMap = new HashMap<>();
        int n = x.size();
        for (int i = 0; i < n; i++) {
            int xCoOrdinate = x.get(i);
            int yCoOrdinate = y.get(i);
            String cityName = c.get(i);

            cityNameToCoOrdinateMap.put(cityName, new int[] {xCoOrdinate, yCoOrdinate});

            if (xCoOrdinateToCityNameMap.containsKey(xCoOrdinate)) {
                PriorityQueue<String> xCoOrdinateCities = xCoOrdinateToCityNameMap.get(xCoOrdinate);
                xCoOrdinateCities.add(cityName);
                xCoOrdinateToCityNameMap.put(xCoOrdinate, xCoOrdinateCities);
            } else {
                PriorityQueue<String> xCoOrdinatecities = new PriorityQueue<>();
                xCoOrdinatecities.add(cityName);
                xCoOrdinateToCityNameMap.put(xCoOrdinate, xCoOrdinatecities);
            }

            if (yCoOrdinateToCityNameMap.containsKey(yCoOrdinate)) {
                PriorityQueue<String> yCoOrdinateCities = yCoOrdinateToCityNameMap.get(yCoOrdinate);
                yCoOrdinateCities.add(cityName);
                yCoOrdinateToCityNameMap.put(yCoOrdinate, yCoOrdinateCities);
            } else {
                PriorityQueue<String> yCoOrdinateCities = new PriorityQueue<>();
                yCoOrdinateCities.add(cityName);
                yCoOrdinateToCityNameMap.put(yCoOrdinate, yCoOrdinateCities);
            }
        }
        List<String> result = new ArrayList<>();
        for (String cityNameValue : q) {
            int[] cityCoOrdinates = cityNameToCoOrdinateMap.get(cityNameValue);
            int xCoOrdinateValue = cityCoOrdinates[0];
            int yCoOrdinateValue = cityCoOrdinates[1];

            if (xCoOrdinateToCityNameMap.containsKey(xCoOrdinateValue)) {
                String neighbouringCity = xCoOrdinateToCityNameMap.get(xCoOrdinateValue).peek();
                if (cityNameValue.equals(neighbouringCity) && xCoOrdinateToCityNameMap.get(xCoOrdinateValue).size() > 1) {
                    String nextNeighbour = xCoOrdinateToCityNameMap.get(xCoOrdinateValue).poll();
                    result.add(xCoOrdinateToCityNameMap.get(xCoOrdinateValue).peek());
                    xCoOrdinateToCityNameMap.get(xCoOrdinateValue).add(nextNeighbour);
                } else if (xCoOrdinateToCityNameMap.get(xCoOrdinateValue).size() == 1) {
                    result.add("NONE");
                } else {
                    result.add(neighbouringCity);
                }
            } else {
                if (yCoOrdinateToCityNameMap.containsKey(yCoOrdinateValue)) {
                    String neighbouringCity = yCoOrdinateToCityNameMap.get(yCoOrdinateValue).peek();
                    if (cityNameValue.equals(neighbouringCity) && yCoOrdinateToCityNameMap.get(yCoOrdinateValue).size() > 1) {
                        String nextNeighbour = yCoOrdinateToCityNameMap.get(yCoOrdinateValue).poll();
                        result.add(yCoOrdinateToCityNameMap.get(yCoOrdinateValue).peek());
                        yCoOrdinateToCityNameMap.get(yCoOrdinateValue).add(nextNeighbour);
                    } else if (yCoOrdinateToCityNameMap.get(yCoOrdinateValue).size() == 1) {
                        result.add("NONE");
                    } else {
                        result.add(neighbouringCity);
                    }
                } else {
                    result.add("NONE");
                }
            }
        }
        return result;
    }

}