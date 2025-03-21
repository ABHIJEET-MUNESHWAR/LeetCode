class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {   
        int n = dist.length;
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = (int) Math.ceil((double) dist[i] / speed[i]);
        }
        Arrays.sort(time);
        int count = 1;
        int timePassed = 1;
        for (int i = 1; i < n; i++) {
            if ((time[i] - timePassed) <= 0) {
                return count;
            }
            count++;
            timePassed++;
        }
        return count;
    }
}