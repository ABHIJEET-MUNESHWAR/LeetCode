class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        if (n == 0) {
          return 0;
        } else {
          for (int i = 1; i < n; i++) {
            if (prices[i - 1] < prices[i]) {
              maxProfit += Math.max(0, prices[i] - prices[i - 1]);
            }
          }
        }
        return maxProfit;
    }
}