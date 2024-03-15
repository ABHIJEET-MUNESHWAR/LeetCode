class Solution {
    public int findFinalValue(int[] nums, int original) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int num = original;
        while (set.contains(num)) {
            num = num * 2;
        }
        return num;
    }
}