class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        int j = 0;
        for (String word : words) {
            int n = word.length();
            for (int i = 0; i < n; i++) {
                if (word.charAt(i) == x) {
                    result.add(j);
                    break;
                }
            }
            j++;
        }
        return result;
    }
}