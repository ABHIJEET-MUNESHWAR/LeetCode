class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];
        if (a == b && b == c) {
            return "equilateral";
        } else if (((a == b) || (b == c) || (a == c)) && (a + b > c) && (b + c > a) && (a + c > b)) {
            return "isosceles";
        } else if (((a != b) && (b != c) && (a != c)) && (a + b > c) && (b + c > a) && (a + c > b)) {
            return "scalene";
        } else {
            return "none";
        }
    }
}