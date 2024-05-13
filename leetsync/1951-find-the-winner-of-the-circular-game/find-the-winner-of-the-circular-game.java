class Solution {
    public int findTheWinner(int n, int k) {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            int count = k;
            while (count-- > 1) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }
}