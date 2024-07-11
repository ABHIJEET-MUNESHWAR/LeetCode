class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
    int n = answerKey.length();
    int result = 0;
    int left = 0;
    int right = 0;
    int countF = 0;
    while (right < n) {
      if (answerKey.charAt(right) == 'F') {
        countF++;
      }
      while (countF > k) {
        if (answerKey.charAt(left) == 'F') {
          countF--;
        }
        left++;
      }
      result = Math.max(result, right - left + 1);
      right++;
    }
    left = 0;
    right = 0;
    int countT = 0;
    while (right < n) {
      if (answerKey.charAt(right) == 'T') {
        countT++;
      }
      while (countT > k) {
        if (answerKey.charAt(left) == 'T') {
          countT--;
        }
        left++;
      }
      result = Math.max(result, right - left + 1);
      right++;
    }
    return result;
    }
}