class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns) {
            if (subStringSearchKmp(word, pattern)) {
                count++;
            }
        }
        return count;
    }

    private boolean subStringSearchKmp(String word, String pattern) {
        char[] wordArray = word.toCharArray();
        char[] patternArray = pattern.toCharArray();
        int[] lps = computeLpsArray(patternArray);
        int i = 0, j = 0;
        while (i < wordArray.length && j < patternArray.length) {
            if (wordArray[i] == patternArray[j]) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
        if (j == patternArray.length) {
            return true;
        }
        return false;
    }

    private int[] computeLpsArray(char[] patternArray) {
        int[] lps = new int[patternArray.length];
        int index = 0;
        for (int i = 1; i < patternArray.length;) {
            if (patternArray[index] == patternArray[i]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}