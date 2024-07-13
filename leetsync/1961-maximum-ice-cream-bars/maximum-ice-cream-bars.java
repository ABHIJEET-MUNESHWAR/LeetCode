class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int result = 0;
        Arrays.sort(costs);
        int n = costs.length;
        for (int i = 0; i < n; i++) {
            coins -= costs[i];
            if (coins < 0) {
                return result;
            }
            result++;
        }
        return result;
    }
}