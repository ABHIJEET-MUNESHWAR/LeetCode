class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {

        int[] result = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            int userId = logs[i][0];
            int minute = logs[i][1];
            Set<Integer> set = new HashSet<>();
            if (map.containsKey(userId)) {
                set = map.get(userId);
            }
            set.add(minute);
            map.put(userId, set);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            result[entry.getValue().size() - 1]++;
        }
        return result;
    }
}