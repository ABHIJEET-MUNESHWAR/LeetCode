class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int size = tickets.length;
        int time = 0;
        for (int i = 0; i < size; i++) {
            if (i <= k) {
                time += Math.min(tickets[k], tickets[i]);
            } else {
                time += Math.min(tickets[k] - 1, tickets[i]);
            }
        }
        return time;
    }
}