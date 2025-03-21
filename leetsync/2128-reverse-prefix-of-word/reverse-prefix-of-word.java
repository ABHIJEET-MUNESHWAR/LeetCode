class Solution {
    public String reversePrefix(String word, char ch) {
        
        int length = word.length();
        char[] letters = word.toCharArray();
        for (int i = 0; i < length; i++) {
            if (letters[i] == ch) {
                for (int j = 0; j < (i + 1) / 2; j++) {
                    char temp = letters[i - j];
                    letters[i - j] = letters[j];
                    letters[j] = temp;
                }
                break;
            }
        }
        return new String(letters);
    }
}