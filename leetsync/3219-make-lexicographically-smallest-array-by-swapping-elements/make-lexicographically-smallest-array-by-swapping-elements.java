class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] sortedNum = nums.clone();
        Arrays.sort(sortedNum);
        int groupNo = 0;
        Map<Integer, Integer> numToGroupMap = new HashMap<>();
        Map<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
        numToGroupMap.put(sortedNum[0], groupNo);
        groupToList.putIfAbsent(groupNo, new LinkedList<>());
        groupToList.get(groupNo).add(sortedNum[0]);
        for (int i = 1; i < n; i++) {
            if (Math.abs(sortedNum[i] - sortedNum[i - 1]) > limit) {
                groupNo++;
            }
            numToGroupMap.put(sortedNum[i], groupNo);
            groupToList.putIfAbsent(groupNo, new LinkedList<>());
            groupToList.get(groupNo).add(sortedNum[i]);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int group = numToGroupMap.get(num);
            result[i] = groupToList.get(group).pollFirst(); // Use and remove the smallest element
        }
        return result;
    }
}