class Solution {
    public int minimumDeletions(String word, int k) {
        int n = word.length();
        int result = n;
        int[] letterFrequency = new int[26];
        for (int i = 0; i < n; i++) {
            letterFrequency[word.charAt(i) - 'a']++;
        }
        Arrays.sort(letterFrequency);
        int cumulativeDeleted = 0;
        for (int i = 0; i < 26; i++) {
            int minimumFrequency = letterFrequency[i];
            int temp = cumulativeDeleted;
            for (int j = 25; j > i; j--) {
                int diff = letterFrequency[j] - letterFrequency[i];
                if (diff <= k) {
                    break;
                }
                temp += letterFrequency[j] - minimumFrequency - k;
            }
            result = Math.min(result, temp);
            cumulativeDeleted += minimumFrequency;
        }
        return result;
    }
}