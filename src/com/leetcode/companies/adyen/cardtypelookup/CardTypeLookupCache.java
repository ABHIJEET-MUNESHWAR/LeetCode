package com.leetcode.companies.adyen.cardtypelookup;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   04-05-2025
    Time:   04:31 pm
    Card Type Lookup Cache
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CardTypeLookupCache {
    private List<BinRange> binRanges;

    public CardTypeLookupCache(List<BinRange> binRanges) {
        binRanges.sort(Comparator.comparingLong(b -> b.start));
        this.binRanges = binRanges;
    }

    public String getCardType(String cardNumber) {
        long cardNumberLong = Long.parseLong(cardNumber);
        int left = 0, right = binRanges.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            BinRange midRange = binRanges.get(mid);
            if (cardNumberLong >= midRange.start && cardNumberLong <= midRange.end) {
                return midRange.cardType;
            } else if (cardNumberLong < midRange.start) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return "Unknown";
    }

    public static void main(String[] args) {
        List<BinRange> binRanges = Arrays.asList(
                new BinRange(4000000000000000L, 4199999999999999L, "Visa"),
                new BinRange(4200080000000000L, 4200089999999999L, "Visa debit"),
                new BinRange(4350000000000000L, 4350009999999999L, "Visa"),
                new BinRange(5400000000000000L, 5999999999999999L, "MasterCard")
        );
        CardTypeLookupCache lookupCache = new CardTypeLookupCache(binRanges);
        System.out.println(lookupCache.getCardType("4111111111111111")); // Output: Visa
        System.out.println(lookupCache.getCardType("4200081234567890")); // Output: Visa Debit
        System.out.println(lookupCache.getCardType("4350001234567890")); // Output: Visa
        System.out.println(lookupCache.getCardType("5500001234567890")); // Output: MasterCard
        System.out.println(lookupCache.getCardType("9999991234567890")); // Output: Unknown
    }
}
