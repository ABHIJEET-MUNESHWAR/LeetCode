class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
    List<Integer> answer = new ArrayList<>();
    int size = nums.length;
    int lesser=0;
    int count=0;
    for (int i = 0; i < size; i++) {
      if(nums[i]<target){
        lesser++;
      }
      if(nums[i]==target){
        count++;
      }
    }
    for (int i = 0; i < count; i++) {
      answer.add(lesser++);
    }
    return answer;       
    }
}