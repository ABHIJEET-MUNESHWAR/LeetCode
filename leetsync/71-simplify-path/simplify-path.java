class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        int size = split.length;
        String[] stack = new String[size];
        int pointer = 0;
        for (int i = 0; i < size; i++) {
            if (split[i].equals(".") || split[i].equals("")) {
                continue;
            }
            if (split[i].equals("..")) {
                if (pointer > 0) {
                    pointer--;
                }
            } else {
                stack[pointer] = split[i];
                pointer++;
            }
        }
        String result = "";
        for (int i = 0; i < pointer; i++) {
            result += "/" + stack[i];
        }
        return result.length() == 0 ? "/" : result;
    }
}