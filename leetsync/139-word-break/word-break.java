class Solution {

    HashSet<String> set = new HashSet<String>();
    Boolean[] dp = new Boolean[301];

    public boolean wordBreak(String s, List<String> wordDict) {
        set.addAll(wordDict);
        return solve(s, 0);
    }

    private boolean solve(String s, int index) {
        if (index >= s.length()) {
            return true;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        for (int endIndex = index + 1; endIndex <= s.length(); endIndex++) {
            String sub = s.substring(index, endIndex);
            if (set.contains(sub) && solve(s, endIndex)) {
                dp[index] = true;
                return true;
            }
        }

        dp[index] = false;
        return false;
    }
}
