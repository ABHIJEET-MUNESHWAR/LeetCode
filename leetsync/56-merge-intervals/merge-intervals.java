class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // Sort based on start point
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int n = intervals.length;
        for (int[] interval : intervals) {
            int currentStart = interval[0];
            int currentEnd = interval[1];
            if (currentStart > result.get(result.size() - 1)[1]) {
                // No Overlap
                result.add(interval);
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], currentEnd);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}