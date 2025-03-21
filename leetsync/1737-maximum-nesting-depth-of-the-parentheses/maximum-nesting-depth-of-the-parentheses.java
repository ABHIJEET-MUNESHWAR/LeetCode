class Solution {
    public int maxDepth(String s) {
        
    int maxDepth = Integer.MIN_VALUE;
    int currCount = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '(') {
        currCount++;
      }
      if (ch == ')') {
        currCount--;
      }
      if (maxDepth < currCount) {
        maxDepth = currCount;
      }
    }
    return maxDepth;
    }
}