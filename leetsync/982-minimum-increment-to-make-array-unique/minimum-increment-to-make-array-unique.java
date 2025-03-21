class Solution {
    public int minIncrementForUnique(int[] nums) {
        int moves = 0;
        int[] frequencyMap = new int[1000000];
        for (int num : nums) {
            frequencyMap[num]++;
        }
        for (int i = 0; i < frequencyMap.length - 1; i++) {
            if (frequencyMap[i] <= 1) {
                continue;
            }
            int remainingMoves = frequencyMap[i] - 1;
            moves += remainingMoves;
            frequencyMap[i + 1] += remainingMoves;
        }
        return moves;
    }
}