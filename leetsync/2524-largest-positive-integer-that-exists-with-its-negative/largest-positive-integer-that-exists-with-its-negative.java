class Solution {
    public int findMaxK(int[] nums) {

        int[] frequencyMap = new int[1001];
        int size = nums.length;
        int answer = -1;
        for (int i = 0; i < size; i++) {
            int num = nums[i];
            int absNum = Math.abs(num);
            if (frequencyMap[absNum] == (-num) && answer < Math.abs(frequencyMap[absNum])) {
                answer = Math.abs(frequencyMap[absNum]);
            }
            frequencyMap[absNum] = num;
        }
        return answer;
    }
}