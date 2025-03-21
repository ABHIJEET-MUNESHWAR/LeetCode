class Solution {
    public int[] productExceptSelf(int[] nums) {

        int size = nums.length;
        int[] answer = new int[size];
        int prefixProduct = 1, postfixProduct = 1;
        for (int i = 0; i < size; i++) {
            prefixProduct = prefixProduct * nums[i];
            answer[i] = prefixProduct;
        }
        for (int i = size - 1; i > 0; i--) {
            answer[i] = answer[i - 1] * postfixProduct;
            postfixProduct = postfixProduct * nums[i];
        }
        answer[0] = postfixProduct;
        return answer;
    }
}