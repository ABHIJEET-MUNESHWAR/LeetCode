class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        int size = split.length;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            if (split[i].equals(".") || split[i].equals("")) {
                continue;
            }
            if (split[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(split[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = "/" + stack.peek() + result;
            stack.pop();
        }
        return result;
    }
}