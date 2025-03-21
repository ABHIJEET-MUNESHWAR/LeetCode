class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        int size = hand.length;
        if (size % groupSize != 0) {
            return false;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            pq.add(num);
        }
        while (!pq.isEmpty()) {
            int num = pq.peek();
            int j = 0;
            for (int i = j; i < j + groupSize; i++) {
                if (map.containsKey(num + i)) {
                    int value = map.get(num + i);
                    if (value > 1) {
                        map.put(num + i, map.get(num + i) - 1);
                    } else if (value == 1) {
                        map.remove(num + i);
                        pq.poll();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            j += groupSize;
        }
        return true;
    }
}