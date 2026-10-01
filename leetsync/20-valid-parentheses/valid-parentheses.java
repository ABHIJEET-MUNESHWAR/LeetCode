class Solution {
    public boolean isValid(String s) {
        String expr = s;
        int length = expr.length();
        Stack stack = new Stack();
        for (int i = 0; i < length; i++) {
            Character c = expr.charAt(i);
            Character peek = '0';
            if (!stack.isEmpty()) {
                peek = (Character) stack.peek();
            }
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case '[':
                    stack.push(c);
                    break;
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (peek == '(') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                    break;
                case ']':
                    if (peek == '[') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                    break;
                case '}':
                    if (peek == '{') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}