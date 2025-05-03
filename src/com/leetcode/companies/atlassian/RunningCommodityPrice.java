package com.leetcode.companies.atlassian;

public interface RunningCommodityPrice {
    void upsertCommodityPrice(int timestamp, int commodityPrice);
    int getMaxCommodityPrice();
}
