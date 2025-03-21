class Solution {
    public int countSeniors(String[] details) {

    int elder = 0;
    for (String detail : details) {
      int age = (detail.charAt(11) - '0') * 10 + detail.charAt(12) - '0';
      if (age > 60) {
        elder++;
      }
    }
    return elder;        
    }
}