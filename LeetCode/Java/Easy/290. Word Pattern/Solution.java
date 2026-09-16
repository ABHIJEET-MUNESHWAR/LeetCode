class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] charArray = pattern.toCharArray();
        String[] wordArray = s.split(" ");
        Map<Character, String> map = new HashMap<>();
        int size = charArray.length;
        if (size != wordArray.length) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (map.containsKey(charArray[i])) {
                String wordFound = map.get(charArray[i]);
                if (!wordFound.equals(wordArray[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(wordArray[i])) {
                    return false;
                }
                map.put(charArray[i], wordArray[i]);
            }
        }
        return true;
    }
}