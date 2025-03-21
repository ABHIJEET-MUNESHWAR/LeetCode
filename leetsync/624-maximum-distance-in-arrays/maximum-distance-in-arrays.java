class Solution {
    public int maxDistance(List<List<Integer>> arrays) {        
        int maxDiff = 0;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int n = arrays.size();
        for (int i = 1; i < n; i++) {
            maxDiff = Math.max(maxDiff, arrays.get(i).get(arrays.get(i).size() - 1) - min);
            maxDiff = Math.max(maxDiff, max - arrays.get(i).get(0));
            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
        }
        return maxDiff;
    }
}