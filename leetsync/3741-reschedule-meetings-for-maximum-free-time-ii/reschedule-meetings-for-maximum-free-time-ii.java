class Solution {
    int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int[] gap = new int[startTime.length + 1], largestRight = new int[startTime.length + 1];
        gap[0] = startTime[0];
        for (int i = 1; i < startTime.length; ++i)
            gap[i] = startTime[i] - endTime[i - 1];
        gap[startTime.length] = eventTime - endTime[endTime.length - 1];
        for (int i = gap.length - 2; i >= 0; --i)
            largestRight[i] = Math.max(largestRight[i + 1], gap[i + 1]);
        int ans = 0, largestLeft = 0;
        for (int i = 1; i < gap.length; ++i) {
            int curGap = endTime[i - 1] - startTime[i - 1];
            if (largestLeft >= curGap || largestRight[i] >= curGap)
                ans = Math.max(ans, gap[i - 1] + gap[i] + curGap);
            ans = Math.max(ans, gap[i - 1] + gap[i]);
            largestLeft = Math.max(largestLeft, gap[i - 1]);
        }
        return ans;
    }
}