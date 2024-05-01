class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }
        while (frequencyMap.size() > 0) {
            List<Integer> integers = new ArrayList<>();
            for (Iterator<Map.Entry<Integer, Integer>> iterator = frequencyMap.entrySet().iterator(); iterator
                    .hasNext();) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() == 0) {
                    iterator.remove();
                } else {
                    integers.add(entry.getKey());
                    entry.setValue(entry.getValue() - 1);
                }
            }
            if (integers.size() > 0) {
                result.add(integers);
            }
        }
        return result;
    }
}