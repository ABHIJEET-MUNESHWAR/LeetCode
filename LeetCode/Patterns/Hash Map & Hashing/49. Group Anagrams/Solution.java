class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> wordToAnagramsMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedCharsString = new String(chars);
            if (!wordToAnagramsMap.containsKey(sortedCharsString)) {
                wordToAnagramsMap.put(sortedCharsString, new ArrayList<>());
            }
            wordToAnagramsMap.get(sortedCharsString).add(str);
        }
        return new ArrayList<>(wordToAnagramsMap.values());
    }
}