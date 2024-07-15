class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {   
        int n = dist.length;
        
        int[] vec = new int[n];
        
        for (int i = 0; i < n; i++) {
            vec[i] = (int) Math.ceil((double) dist[i] / speed[i]);
        }
        
        Arrays.sort(vec);
        
        int count = 1;
        
        int timePassed = 1;
        for (int i = 1; i < n; i++) {
            if (vec[i] - timePassed <= 0) {
                return count;
            }
            
            count++;
            timePassed++;
        }
        
        return count;
    }
}