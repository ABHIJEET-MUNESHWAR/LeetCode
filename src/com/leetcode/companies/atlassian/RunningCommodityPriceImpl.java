package com.leetcode.companies.atlassian;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   25-04-2025
    Time:   10:54 am
*/

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static java.util.Comparator.reverseOrder;

public class RunningCommodityPriceImpl implements RunningCommodityPrice {
    Map<Integer, Integer> timeToPriceMap;
    TreeMap<Integer, Set<Integer>> priceToTimeListTreeMap;

    public RunningCommodityPriceImpl() {
        timeToPriceMap = new TreeMap<>();
        priceToTimeListTreeMap = new TreeMap<>(reverseOrder());
    }

    @Override
    public void upsertCommodityPrice(int timestamp, int commodityPrice) {
        if (timeToPriceMap.containsKey(timestamp)) {
            Integer oldPrice = timeToPriceMap.get(timestamp);
            Set<Integer> timeStampList = priceToTimeListTreeMap.get(oldPrice);
            timeStampList.remove(timestamp);
            if (timeStampList.isEmpty()) {
                priceToTimeListTreeMap.remove(oldPrice);
            } else {
                priceToTimeListTreeMap.put(commodityPrice, timeStampList);
            }
        }
        timeToPriceMap.put(timestamp, commodityPrice);
        Set<Integer> timeStampList = priceToTimeListTreeMap.get(commodityPrice);
        if (timeStampList == null || timeStampList.isEmpty()) {
            timeStampList = new HashSet<>();
        }
        timeStampList.add(timestamp);
        priceToTimeListTreeMap.put(commodityPrice, timeStampList);
    }

    @Override
    public int getMaxCommodityPrice() {
        return priceToTimeListTreeMap.firstKey();
    }
}
