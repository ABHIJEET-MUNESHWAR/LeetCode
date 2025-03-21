class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int size = deck.length;
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            queue.add(i);
        }
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }
        return answer;
    }
}