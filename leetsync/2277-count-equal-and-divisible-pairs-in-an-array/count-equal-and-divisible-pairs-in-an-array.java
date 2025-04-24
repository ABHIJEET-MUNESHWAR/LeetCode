class Solution {
    public int countPairs(int[] nums, int k) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                for (Integer num : list) {
                    int mul = num * i;
                    if ((mul) % k == 0) {
                        count++;
                    }
                }
                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        return count;        
    }
}