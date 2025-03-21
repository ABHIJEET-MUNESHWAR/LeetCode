class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openingStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '*':
                    starStack.push(i);
                    break;
                case '(':
                    openingStack.push(i);
                    break;
                case ')':
                    if (!openingStack.isEmpty()) {
                        openingStack.pop();
                    } else if (!starStack.isEmpty()) {
                        starStack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        while (!openingStack.isEmpty()) {
            if (starStack.isEmpty()) {
                return false;
            }
            if (openingStack.pop() > starStack.pop()) {
                return false;
            }
        }
        return openingStack.isEmpty();
    }
}