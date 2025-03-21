class Solution {
    public int maximumGain(String s, int x, int y) {
        int result = 0;
        String maxSubString = x > y ? "ab" : "ba";
        String minSubString = x < y ? "ab" : "ba";
        String firstFilteredString = removeSubStringWithoutStack(s, maxSubString);
        result += ((s.length() - firstFilteredString.length()) / 2) * (Math.max(x, y));
        String secondFilteredString = removeSubStringWithoutStack(firstFilteredString, minSubString);
        result += ((firstFilteredString.length() - secondFilteredString.length()) / 2) * (Math.min(x, y));
        return result;
    }

    private String removeSubStringWithoutStack(String s, String subString) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (char ch : s.toCharArray()) {
            sb.append(ch);
            j++;
            if (j > 1 && sb.charAt(j - 2) == subString.charAt(0) && sb.charAt(j - 1) == subString.charAt(1)) {
                sb.delete(j - 2, j);
                j -= 2;
            }
        }
        return sb.toString();
    }
}