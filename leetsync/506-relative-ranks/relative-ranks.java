class Solution {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, String> positionMap = new HashMap<>();
        int size = score.length;
        String[] ans = new String[size];
        for (int i = 0; i < size; i++) {
            positionMap.put(score[i], (i + 1) + "");
        }
        int[] inputScore = new int[size];
        for (int i = 0; i < size; i++) {
            inputScore[i] = score[i];
        }
        Arrays.sort(score);
        for (int i = size - 4, j = 0; i >= 0; i--, j++) {
            positionMap.put(score[i], (j + 4) + "");
        }
        int startIndex = size - 3;
        if (size == 1) {
            positionMap.put(score[0], "Gold Medal");
        } else if (size == 2) {
            positionMap.put(score[0], "Silver Medal");
            positionMap.put(score[1], "Gold Medal");
        } else {
            positionMap.put(score[startIndex++], "Bronze Medal");
            positionMap.put(score[startIndex++], "Silver Medal");
            positionMap.put(score[startIndex++], "Gold Medal");
        }
        for (int i = 0; i < size; i++) {
            ans[i] = positionMap.get(inputScore[i]);
        }
        return ans;       
    }
}