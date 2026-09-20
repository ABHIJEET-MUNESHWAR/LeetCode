class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverseWords(chars, n);
        return cleanSpaces(chars, n);
    }

    private String cleanSpaces(char[] chars, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && chars[j] == ' ') {
                // skip spaces
                j++;
            }
            while (j < n && chars[j] != ' ') {
                // keep non spaces
                chars[i++] = chars[j++];
            }
            while (j < n && chars[j] == ' ') {
                // skip spaces
                j++;
            }
            if (j < n) {
                chars[i++] = ' ';
            }
        }
        return new String(chars, 0, i);
    }

    private void reverseWords(char[] chars, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && chars[i] == ' ') {
                i++; // skip spaces
            }
            while (j < i || j < n && chars[j] != ' ') {
                j++; // skip non spaces
            }
            reverse(chars, i, j - 1);
        }
    }

    private String reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return new String(chars);
    }
}