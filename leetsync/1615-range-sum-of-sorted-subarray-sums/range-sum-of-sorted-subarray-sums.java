class Solution {

    int mod = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                tempList.add(sum);
            }
        }
        Collections.sort(tempList);
        int result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + tempList.get(i)) % mod;
        }
        return result;
    }
}