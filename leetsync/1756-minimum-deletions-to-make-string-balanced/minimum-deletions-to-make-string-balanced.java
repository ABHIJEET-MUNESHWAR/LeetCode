class Solution {
    public int minimumDeletions(String s) {   
        Stack<Character> stack = new Stack<>();
        int deletedCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'b') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == 'b') {
                    deletedCount++;
                    stack.pop();
                }
            }
        }
        return deletedCount;
    }
}