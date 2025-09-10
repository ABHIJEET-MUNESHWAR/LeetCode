package com.leetcode.companies.ring.central;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   10-09-2025
    Time:   03:11 pm
*/
/*
1 Candy is for 1 Rs.  3 Candy wrappers can give us 1 Candy. If given some money, then identify how many max candy can we get.
Example: Input: 15 Rs: Output 22

// 1 Candy = 1 Rs
// 3 Candy wrappers = 1 Candy
// If given some money, then identify how many max candy can we get
// Input: 15 Rs
// 15 Rs -> 15 Candies
// 15 Candies -> 15 Wrappers -> 5 Candies
// 5 Candies -> 5 Wrappers -> 1 Candies + 2 Wrappers
// 1 Candy -> 1 Wrapper + 2 Wrappers = 1 Candy
// 1 Candy -> 1 Wrapper -> 0 Candy
// Answer = 15 + 5 + 1 + 1 = 22 Candies

https://chatgpt.com/c/68b5c0ff-51e8-8333-b1ed-0557a4427978
 */

public class CandyWrappers {
    public static void main(String[] args) {
        CandyWrappers candyWrappers = new CandyWrappers();
        int           money         = 15, price = 1, k = 3;
        System.out.println(candyWrappers.maxCandies(money, price, k));
    }

    private int maxCandies(int money, int price, int k) {
        int candies  = money / price;
        int wrappers = candies;
        while (wrappers >= k) {
            int extra = wrappers / k;
            candies += extra;
            wrappers = extra + wrappers % k;
        }
        return candies;
    }
}
