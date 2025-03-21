class Solution {
    public int maxCoins(int[] piles) {

        int size = piles.length;
        Arrays.sort(piles);
        int answer = 0;
        for (int i = size - 2; i >= size/3; i -= 2) {
            answer += piles[i];
        }
        return answer;
    }
}