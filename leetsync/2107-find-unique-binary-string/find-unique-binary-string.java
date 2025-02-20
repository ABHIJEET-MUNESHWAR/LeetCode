class Solution {
    public String findDifferentBinaryString(String[] nums) {
        String answer = "";
        for (int i = 0; i < nums.length; i++) {
            char ch = nums[i].charAt(i);
            if (ch == '1') {
                answer += '0';
            } else {
                answer += '1';
            }
        }
        return answer;
    }
}