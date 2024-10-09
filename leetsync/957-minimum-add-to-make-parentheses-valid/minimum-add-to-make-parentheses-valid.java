class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int size = 0, open = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                size++;
            } else if (size > 0) {
                size--;
            } else {
                open++;
            }
        }
        return size + open;
    }
}