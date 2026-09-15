class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = Integer.MAX_VALUE; //
        int maxProfit = Integer.MIN_VALUE;
        int pist = 0; // Profit if sold today
        if (n == 0) {
          return 0;
        } else {
          for (int i = 0; i < n; i++) {
            if (min > prices[i]) {
              min = prices[i];
            }
            pist = prices[i] - min;
            if (maxProfit < pist) {
              maxProfit = pist;
            }
          }
        }
        return maxProfit;
    }
}