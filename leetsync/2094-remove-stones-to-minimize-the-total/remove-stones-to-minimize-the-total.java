class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (Integer pile : piles) {
            minHeap.add(pile);
            sum += pile;
        }
        while (k-- > 0) {
            int pile = minHeap.poll();
            int remove = pile / 2;
            sum -= remove;
            int remaining = pile - remove;
            minHeap.add(remaining);
        }
        return sum;
    }
}