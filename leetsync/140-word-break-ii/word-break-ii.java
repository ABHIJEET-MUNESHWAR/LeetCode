class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        List<String> result = new ArrayList<>();
        solve(s, 0, "", set, result);
        return result;
    }

    private void solve(String s, int index, String currentSentence, Set<String> set, List<String> result) {
        if (index >= s.length()) {
            result.add(currentSentence);
            return;
        }
        for (int endIndex = index; endIndex < s.length(); endIndex++) {
            String subString = s.substring(index, endIndex + 1);
            if (set.contains(subString)) {
                String tempSentence = currentSentence;
                if (!currentSentence.isEmpty()) {
                    currentSentence += " ";
                }
                currentSentence += subString;
                solve(s, endIndex + 1, currentSentence, set, result);
                currentSentence = tempSentence;
            }
        }
    }
}