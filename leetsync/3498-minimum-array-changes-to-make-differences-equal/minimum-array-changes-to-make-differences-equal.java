class Solution {
    public int minChanges(int[] nums, int k) {    
        Map<Integer, Integer> s = new HashMap<>();
        int n = nums.length;
        int[] f = new int[k + 1];
        for (int i = 0; i < n / 2; i++) {
            int diff = Math.abs(nums[i] - nums[n - 1 - i]);
            s.put(diff, s.getOrDefault(diff, 0) + 1);
            int min = Math.min(nums[i], nums[n - i - 1]);
            int max = Math.max(nums[i], nums[n - i - 1]);
            f[Math.max(k - min, max)]++;
        }
        for (int i = k - 1; i >= 0; i--) {
            f[i] += f[i + 1];
        }
        int ans = n;

        for (int x : s.keySet()) {
            int one = f[x] - s.get(x);
            int two = n / 2 - f[x];
            ans = Math.min(ans, one + two * 2);
        }
        return ans;
    }
}