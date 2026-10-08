class Solution {
    public String removeOuterParentheses(String s) {

    StringBuilder sb = new StringBuilder();
    int length = s.length();
    int open = 0, close = 0, start = 0;
    for (int i = 0; i < length; i++) {
      if (s.charAt(i) == '(') {
        open++;
      } else {
        close++;
      }
      if (open == close) {
        sb.append(s.substring(start + 1, i));
        start = i + 1;
      }
    }
    return sb.toString();        
    }
}