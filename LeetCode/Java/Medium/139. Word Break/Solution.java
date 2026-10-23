class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>();
        wordDictSet.addAll(wordDict);
        Boolean[] dp = new Boolean[301];
        return wordBreakBackTrack(s, wordDictSet, s.length(), 0, dp);
    }

    public boolean wordBreakBackTrack(String s, Set<String> wordDictSet, int n, int i, Boolean[] dp) {
        if (i >= n) {
            return true;
        }
        if (wordDictSet.contains(s)) {
            return true;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        for (int j = i + 1; j <= n; j++) {
            String subString = s.substring(i, j);
            if (wordDictSet.contains(subString) && wordBreakBackTrack(s, wordDictSet, n, j, dp)) {
                dp[i] = true;
                return true;
            }
        }
        dp[i] = false;
        return false;
    }
}