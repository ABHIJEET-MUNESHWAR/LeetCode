class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] isBroken = new boolean[26];
        for (char ch : brokenLetters.toCharArray()) {
            isBroken[ch - 'a'] = true;
        }
        int result = 0;
        boolean isFoundBroken = false;
        for (char ch : text.toCharArray()) {
            if (ch == ' ') {
                if (!isFoundBroken) {
                    result++;
                }
                isFoundBroken = false; // Reset for next word
            } else if (isBroken[ch - 'a']) {
                isFoundBroken = true;
            }
        }
        if (!isFoundBroken) {
            result++;
        }
        return result;
    }
}