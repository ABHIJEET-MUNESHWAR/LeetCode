class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int valueComparision = Integer.compare(a[0], b[0]);
            if (valueComparision == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return valueComparision;
        });
        for (int i = 0; i < n; i++) {
            pq.add(new int[] { nums[i], i });
        }
        while (k-- > 0) {
            int[] current = pq.poll();
            int num = current[0];
            int index = current[1];
            nums[index] *= multiplier;
            current[0] *= multiplier;
            pq.add(current);
        }
        return nums;
    }
}