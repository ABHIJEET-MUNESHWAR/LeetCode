class Solution {
    public int appendCharacters(String s, String t) {
        int sourceSize = s.length();
        int targetSize = t.length();
        int answer = 0;
        int i = 0, j = 0;
        while (i < sourceSize && j < targetSize) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        answer = targetSize - j;
        return answer;
    }
}