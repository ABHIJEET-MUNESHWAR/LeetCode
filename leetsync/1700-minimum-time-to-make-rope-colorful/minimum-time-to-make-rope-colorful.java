class Solution {
    public int minCost(String colors, int[] neededTime) {

        int time = 0;
        int previousmax = 0;
        int n = colors.length();
        for (int i = 0; i < n; i++) {
            if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) {
                previousmax = 0;
            }
            int currentTime = neededTime[i];
            // Greedily select the minimum between prevMax and curr
            time += Math.min(previousmax, currentTime);
            // Update prevMax to the maximum between prevMax and curr
            previousmax = Math.max(previousmax, currentTime);
        }
        return time;
    }
}