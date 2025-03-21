class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        int[] count = new int[size + 1];
        for (int num : nums) {
            int frequency = count[num];
            if (frequency == result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(frequency).add(num);
            count[num]++;
        }
        return result;
    }
}