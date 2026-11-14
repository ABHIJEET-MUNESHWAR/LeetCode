class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int[] pre = new int[nums.size() + 1]; // pre[i] = sum(nums[:i])
        for (int i = 0; i < nums.size(); i++)
            pre[i + 1] = pre[i] + nums.get(i);
        return IntStream.rangeClosed(l, r)
                .flatMap(k -> IntStream.range(0, pre.length - k).map(i -> pre[i + k] - pre[i]))
                .filter(s -> s > 0)
                .min()
                .orElse(-1);
    }
}