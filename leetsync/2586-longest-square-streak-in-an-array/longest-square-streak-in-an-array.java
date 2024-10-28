class Solution {
    public int longestSquareStreak(int[] nums) {
        int n = nums.length;
        int longestStreak = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            int streak = 0;
            long current = num;
            while (set.contains((int) current)) {
                streak++;
                if (current * current > 1e5) {
                    break;
                }
                current = current * current;
            }
            longestStreak = Math.max(longestStreak, streak);
        }
        return longestStreak >= 2 ? longestStreak : -1;
    }
}