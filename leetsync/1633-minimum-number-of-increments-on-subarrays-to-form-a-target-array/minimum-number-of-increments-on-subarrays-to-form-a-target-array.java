class Solution {
    public int minNumberOperations(int[] target) {        
        int result = 0;
        int n = target.length;
        int prev = 0, curr = 0;
        for (int i = 0; i < n; i++) {
            curr = target[i];
            if (Math.abs(prev) < Math.abs(curr)) {
                result += Math.abs(curr - prev);
            }
            prev = curr;
        }
        return result;
    }
}