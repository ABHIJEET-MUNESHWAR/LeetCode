class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pre = strs[0];
        int len = strs.length;
        for (int i = 1; i < len; i++) {
            while (!strs[i].startsWith(pre)) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;
    }
}