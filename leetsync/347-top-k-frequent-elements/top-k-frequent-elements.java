class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> mapHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        mapHeap.addAll(map.entrySet());
        List<Integer> list = new ArrayList<>();
        while (list.size() < k) {
            list.add(mapHeap.poll().getKey());
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}