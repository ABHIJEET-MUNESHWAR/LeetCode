class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        int score = 0;
        String maxStr = (x > y) ? "ab" : "ba";
        String minStr;

        if (maxStr.equals("ab")) {
            minStr = "ba";
        } else {
            minStr = "ab";
        }

        // First Pass
        String tempFirst = removeSubString(s, maxStr);
        int removedPairsCount = (n - tempFirst.length()) / 2;
        score += removedPairsCount * Math.max(x, y);

        // Second Pass
        String tempSecond = removeSubString(tempFirst, minStr);
        removedPairsCount = (tempFirst.length() - tempSecond.length()) / 2;
        score += removedPairsCount * Math.min(x, y);
        return score;
    }

    public String removeSubString(String inputString, String matchStr) {
        StringBuilder sb = new StringBuilder();
        int j = 0;

        for (int i = 0; i < inputString.length(); i++) {
            sb.append(inputString.charAt(i));
            j++;

            if (j > 1 && sb.charAt(j - 2) == matchStr.charAt(0) && sb.charAt(j - 1) == matchStr.charAt(1)) {
                sb.delete(j - 2, j);
                j -= 2;
            }
        }

        return sb.toString();
    }
}