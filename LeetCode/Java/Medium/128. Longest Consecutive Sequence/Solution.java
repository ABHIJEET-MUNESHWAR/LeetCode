class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Set<Integer> ans = new HashSet<>();
        int longest = 1;
        for (int i = 0; i < nums.length; i++) {
            ans.add(nums[i]);
        }
        for (int it : ans) {
            int count = 1;
            if (!ans.contains(it - 1)) {
                int x = it;
                while (ans.contains(x + 1)) {
                    x++;
                    count++;
                }
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}