class Solution {
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                result.deleteCharAt(result.length() - 1);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}