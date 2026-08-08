class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> resultList = new ArrayList<>();
        String currentList = new String();
        Set<String> wordDictSet = new HashSet<>();
        wordDictSet.addAll(wordDict);
        backTrackWordBreak(s, wordDictSet, currentList, resultList, 0);
        return resultList;
    }

    public void backTrackWordBreak(String s, Set<String> wordDictSet, String currentList, List<String> resultList,
            int i) {
        int n = s.length();
        if (i == n) {
            resultList.add(new String(currentList));
            return;
        }
        for (int j = i + 1; j <= n; j++) {
            String subString = s.substring(i, j);
            if (wordDictSet.contains(subString)) {
                String temp = currentList;
                currentList = currentList.isEmpty() ? subString : currentList + " " + subString;
                backTrackWordBreak(s, wordDictSet, currentList, resultList, j);
                currentList = temp;
            }
        }
    }
}