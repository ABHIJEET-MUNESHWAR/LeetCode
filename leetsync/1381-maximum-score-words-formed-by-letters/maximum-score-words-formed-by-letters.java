class Solution {
    int maxScore = Integer.MIN_VALUE;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] frequencyMap = new int[26];
        for (char c : letters) {
            frequencyMap[c - 'a']++;
        }
        solve(words, 0, score, 0, frequencyMap);
        return maxScore;
    }

    private void solve(String[] words, int index, int[] score, int currentScore, int[] frequencyMap) {
        maxScore = Math.max(maxScore, currentScore);
        if (index >= words.length) {
            return;
        }
        // can we take word[index]
        int j = 0;
        int tempScore = 0;
        int[] tempFrequencyMap = new int[26];
        for (int i = 0; i < 26; i++) {
            tempFrequencyMap[i] = frequencyMap[i];
        }
        while (j < words[index].length()) {
            char c = words[index].charAt(j);
            tempFrequencyMap[c - 'a']--;
            tempScore += score[c - 'a'];
            if (tempFrequencyMap[c - 'a'] < 0) {
                break;
            }
            j++;
        }
        if (j == words[index].length()) {
            // we were able to form this word words[i]
            // Take option
            solve(words, index + 1, score, currentScore + tempScore, tempFrequencyMap);
        }
        // Skip
        solve(words, index + 1, score, currentScore, frequencyMap);
    }
}