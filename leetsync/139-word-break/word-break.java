class Solution {

    HashSet<String> set = new HashSet<String>();

    public boolean wordBreak(String s, List<String> wordDict) {
        set.addAll(wordDict);
        return solveBottomUp(s);
    }

    private boolean solveBottomUp(String s) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int size = s.length();
        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
