class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]);
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            int[] currentInterval = intervals[i];
            int currentIntervalStart = currentInterval[0];
            int currentIntervalEnd = currentInterval[1];
            if (mergedIntervals.get(mergedIntervals.size() - 1)[1] < currentIntervalStart) {
                // No overlap
                mergedIntervals.add(currentInterval);
            } else {
                mergedIntervals.get(mergedIntervals.size() - 1)[1] = Math
                        .max(mergedIntervals.get(mergedIntervals.size() - 1)[1], currentIntervalEnd);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}