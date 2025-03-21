public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int size = num.length();
        for (int i = 0; i < size; i++) {
            Character ch = num.charAt(i);
            while ((k > 0) && (!stack.isEmpty()) && (stack.peek() > ch)) {
                stack.pop();
                k--;
            }
            if (ch != '0' || !stack.isEmpty()) {
                stack.push(ch);
            }
        }
        // Now remove larger values from top of stack
        // e.g. num = 123 & k=2
        while (k-- > 0 && !stack.isEmpty()) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            return "0";
        }
        String answer = "";
        while (!stack.isEmpty()) {
            answer = stack.pop() + answer;
        }
        return answer;
    }
}