class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> openBracketIndex = new Stack<>();
        int n = s.length();
        int[] door = new int[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openBracketIndex.push(i);
            } else if (c == ')') {
                int openBracket = openBracketIndex.pop();
                door[i] = openBracket;
                door[openBracket] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int flag = 1;
        for (int i = 0; i < n; i += flag) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = door[i];
                flag = -flag;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}