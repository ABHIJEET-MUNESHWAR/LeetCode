class Solution {
    public int longestConsecutive(int[] nums) {

        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentMax = 1;
                int currentNum = num;
                while (set.contains(currentNum + 1)) {
                    currentMax++;
                    currentNum++;
                }
                max = Math.max(max, currentMax);
            }
        }
        return max;
    }
}