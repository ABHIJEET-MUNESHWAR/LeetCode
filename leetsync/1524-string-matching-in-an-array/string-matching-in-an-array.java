class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> wordSet = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (searchKMP(words[i], words[j])) {
                    wordSet.add(words[i]);
                    break;
                }
            }
        }
        return wordSet;
    }

    private boolean searchKMP(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();

        // Create an LPS array to store the longest proper prefix which is also a suffix
        // lps[i] = the longest proper prefix of pat[0..i] which is also a suffix of
        // pat[0..i].
        int[] lps = new int[m];
        computeLps(pattern, lps);
        int i = 0; // Index for text
        int j = 0; // Index for pattern
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                // result.add(i-j+1); // Pattern found at index i-j+1 (If you have to return 1
                // Based indexing, that's why added + 1)
                // j = lps[j - 1];
                return true;
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    // Function to compute the LPS (Longest Proper Prefix which is also Suffix)
    // array
    private void computeLps(String pattern, int[] lps) {
        int m = pattern.length();
        int length = 0; // Length of the previous longest prefix & suffix
        lps[0] = 0; // Because there is no proper suffix and prefix of pattern[0..0]
        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1]; // You can also write, len = len-1;
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}