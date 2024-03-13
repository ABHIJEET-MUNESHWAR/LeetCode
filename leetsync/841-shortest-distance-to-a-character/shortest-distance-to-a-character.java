class Solution {
    public int[] shortestToChar(String s, char c) {

        int size = s.length();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            char ch = s.charAt(i);
            if (ch == c) {
                answer[i] = 0;
            } else {
                int a = i, b = i;
                while (a >= 0 || b <= size) {
                    if ((a >= 0) && (s.charAt(a) == c)) {
                        answer[i] = i - a;
                        break;
                    }
                    if ((b < size) && (s.charAt(b) == c)) {
                        answer[i] = b - i;
                        break;
                    }
                    a--;
                    b++;
                }
            }
        }
        return answer;
    }
}