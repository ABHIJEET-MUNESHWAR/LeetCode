class Solution {
    int[] dp;

    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for (String d : dictionary) {
            set.add(d);
        }
        dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return solveRecursionMemoization(s, set, 0);
    }

    private int solveRecursionMemoization(String s, Set<String> set, int index) {
        if (index >= s.length()) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int minChars = s.length();
        for (int i = index; i < s.length(); i++) {
            String currentSubString = s.substring(index, i + 1);
            if (set.contains(currentSubString)) {
                minChars = Math.min(minChars, solveRecursionMemoization(s, set, i + 1));
            } else {
                minChars = Math.min(minChars, currentSubString.length() + solveRecursionMemoization(s, set, i + 1));
            }
        }
        return dp[index] = minChars;
    }
}