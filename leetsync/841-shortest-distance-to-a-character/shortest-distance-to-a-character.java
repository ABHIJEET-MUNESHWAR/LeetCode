class Solution {
    public int[] shortestToChar(String s, char c) {
        int size = s.length();
        int[] answer = new int[size];
        int pos = -size;
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            answer[i] = i - pos;
        }
        for (int i = pos - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            answer[i] = Math.min(answer[i], pos - i);
        }
        return answer;
    }
}