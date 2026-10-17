class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>();
        wordDictSet.addAll(wordDict);
        return wordBreakBackTrack(s, wordDictSet, s.length(), 0);
    }

    public boolean wordBreakBackTrack(String s, Set<String> wordDictSet, int n, int i) {
        if (i >= n) {
            return true;
        }
        if (wordDictSet.contains(s)) {
            return true;
        }
        for (int j = i + 1; j <= n; j++) {
            String subString = s.substring(i, j);
            if (wordDictSet.contains(subString) && wordBreakBackTrack(s, wordDictSet, n, j)) {
                return true;
            }
        }
        return false;
    }
}