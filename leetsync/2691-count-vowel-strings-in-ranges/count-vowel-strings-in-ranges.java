class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int wordsLen = words.length;
        int[] prefixArray = new int[wordsLen];
        int sum = 0;
        for (int i = 0; i < wordsLen; i++) {
            String word = words[i];
            if (isWordStartEndWithVowel(word)) {
                sum++;
            }
            prefixArray[i] = sum;
        }
        int queriesLen = queries.length;
        int[] result = new int[queriesLen];
        for (int i = 0; i < queriesLen; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            result[i] = prefixArray[r] - (l > 0 ? prefixArray[l - 1] : 0);
        }
        return result;
    }

    public boolean isWordStartEndWithVowel(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return isVowel(first) && isVowel(last);
    }

    private boolean isVowel(char character) {
        return character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u';
    }
}