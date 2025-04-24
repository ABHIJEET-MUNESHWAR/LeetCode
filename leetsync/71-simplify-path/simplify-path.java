class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String result = "";
        String[] tokens = path.split("/");
        for (String token : tokens) {
            if (token.equals("") || token.equals(".")) {
                continue;
            }
            if (!token.equals("..")) {
                stack.push(token);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }
        if (result.length() == 0) {
            result = "/";
        }
        return result;
    }
}