class Solution {
    public int findMajorityElement(List<Integer> nums) {
        int counter = 0;
        int majorityElement = -1;
        for (Integer num : nums) {
            if (counter == 0) {
                majorityElement = num;
                counter = 1;
            } else if (majorityElement == num) {
                counter++;
            } else {
                counter--;
            }
        }
        return majorityElement;
    }

    public int minimumIndex(List<Integer> nums) {

        // Step 1: Find majority element using Boyer-Moore Voting Algorithm
        int majorityElement = findMajorityElement(nums);

        // Step 2: Count how many times majority element occurs
        int majorityElementCount = 0;
        for (Integer num : nums) {
            if (num == majorityElement) {
                majorityElementCount++;
            }
        }

        int n = nums.size();

        // Step 3: Try splitting at every index to check conditions
        int count = 0;

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            if (num == majorityElement) {
                count++;
            }
            int remainingCount = majorityElementCount - count;
            int n1 = i + 1;
            int n2 = n - i - 1;
            if (count > (n1 / 2) && remainingCount > (n2 / 2)) {
                return i;
            }
        }
        return -1;
    }
}