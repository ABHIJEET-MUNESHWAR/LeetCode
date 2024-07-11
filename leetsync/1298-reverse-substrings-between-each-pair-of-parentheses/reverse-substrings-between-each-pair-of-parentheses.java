class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> startParenthesesStack = new Stack<>();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            switch (ch) {
                case '(':
                    startParenthesesStack.push(i);
                    break;
                case ')':
                    int startIndex = startParenthesesStack.pop();
                    s = reverseString(s, startIndex + 1, i - 1);
                    break;
            }
        }
        chars = s.toCharArray();
        for (char c : chars) {
            if (c != ')' && c != '(') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private String reverseString(String s, int start, Integer end) {
        int i = start;
        int j = end;
        char[] chars = s.toCharArray();
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }
}