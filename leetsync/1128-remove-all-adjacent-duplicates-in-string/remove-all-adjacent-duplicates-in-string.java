class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            }

        }
        s = "";
        while (!stack.isEmpty()) {
            s = stack.pop() + s;
        }
        return s;
    }
}