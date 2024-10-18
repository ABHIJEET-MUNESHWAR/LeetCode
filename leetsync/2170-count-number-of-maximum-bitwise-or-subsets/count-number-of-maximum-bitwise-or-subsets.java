class Solution {
    public int countSubSets(int index, int currentOr, int maxOr, int[] nums) {
        if (index == nums.length) {
            if (currentOr == maxOr) {
                return 1; // Found one subset
            }
            return 0;
        }

        // Take nums[idx]
        int takeCount = countSubSets(index + 1, currentOr | nums[index], maxOr, nums);

        // Not taken nums[idx]
        int skipCount = countSubSets(index + 1, currentOr, maxOr, nums);

        return takeCount + skipCount;
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }
        int currentOr = 0;
        return countSubSets(0, currentOr, maxOr, nums);
    }
}