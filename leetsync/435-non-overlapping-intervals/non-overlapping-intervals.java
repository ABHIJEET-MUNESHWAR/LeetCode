class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int end = Integer.MIN_VALUE;
        int remove = 0;
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                end = interval[1];
            } else {
                remove++;
            }
        }
        return remove;
    }
}