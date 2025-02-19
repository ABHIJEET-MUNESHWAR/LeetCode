class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        String num = "";
        Stack<Character> stack = new Stack<>();
        int counter = 1;
        for (int i = 0; i <= n; i++) {
            stack.push((char) ('0' + counter));
            counter++;
            if (i == n || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    num += stack.pop();
                }
            }
        }
        return num;
    }
}