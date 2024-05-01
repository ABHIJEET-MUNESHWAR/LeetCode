class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int n = nums.length, count[] = new int[n + 1];
        for (int a : nums) {
            if (res.size() < ++count[a])
                res.add(new ArrayList<>());
            res.get(count[a] - 1).add(a);
        }
        return res;
    }
}