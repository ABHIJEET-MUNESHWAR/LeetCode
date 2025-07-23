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

    public String removeSubString(String s, String matchStr) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == matchStr.charAt(0) && ch == matchStr.charAt(1)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder remainingStr = new StringBuilder();
        while (!stack.isEmpty()) {
            remainingStr.append(stack.pop());
        }
        return remainingStr.reverse().toString();
    }
}