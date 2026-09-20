package com.leetcode.companies.docusign.ratelimiter;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   20/09/26
    Time:   8:58 am
*/

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RateLimiter {
    private final int limit;
    private final int timeWindow;
    Map<String, Deque<Long>> requests = new HashMap<>();

    public RateLimiter(int limit, int timeWindow) {
        this.limit = limit;
        this.timeWindow = timeWindow;
    }

    public boolean allowRequest(String clientId) {
        long        currentTime = System.currentTimeMillis();
        Deque<Long> timeStamps  = requests.computeIfAbsent(clientId, k -> new LinkedList<>());
        while (!timeStamps.isEmpty() && ((currentTime - timeStamps.peekFirst()) >= timeWindow)) {
            timeStamps.pollFirst();
        }
        if (timeStamps.size() >= limit) {
            return false;
        }
        timeStamps.addLast(currentTime);
        return true;
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(3, 10000); // 3 requests per 10 seconds
        String      clientId    = "client1";

        System.out.println(rateLimiter.allowRequest(clientId)); // true
        System.out.println(rateLimiter.allowRequest(clientId)); // true
        System.out.println(rateLimiter.allowRequest(clientId)); // true
        System.out.println(rateLimiter.allowRequest(clientId)); // false


        try {
            Thread.sleep(10000); // Wait for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(rateLimiter.allowRequest(clientId)); // true
    }
}
