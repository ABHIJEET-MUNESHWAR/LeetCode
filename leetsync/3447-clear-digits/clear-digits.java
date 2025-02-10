class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}