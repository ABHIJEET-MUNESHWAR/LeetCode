class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int left = 0, right = 0, profit = 0, maxProfit = 0;
        while (right < n) {
            if (prices[left] < prices[right]) {
                profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}