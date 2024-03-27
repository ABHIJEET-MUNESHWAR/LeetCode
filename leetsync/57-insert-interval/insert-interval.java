class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int totalIntervals = intervals.length;
        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i < totalIntervals; i++) {
            if (newInterval[1] < intervals[i][0]) {
                answer.add(newInterval);
                newInterval = intervals[i];
            } else if (newInterval[0] > intervals[i][1]) {
                answer.add(intervals[i]);
            } else {
                newInterval = new int[] { Math.min(newInterval[0], intervals[i][0]),
                        Math.max(newInterval[1], intervals[i][1]) };
            }
        }
        answer.add(newInterval);
        return answer.toArray(new int[answer.size()][2]);
    }
}