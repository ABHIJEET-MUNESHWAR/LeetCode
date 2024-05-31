class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        String result = "";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}