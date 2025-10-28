impl Solution {
    pub fn count_valid_selections(nums: Vec<i32>) -> i32 {
        
        let mut total_sum = 0;
        let mut curr_sum = 0;
        let mut result = 0;
        let n = nums.len();
        for num in nums.iter() {
            total_sum += num;
        }
        for i in 0..n {
            curr_sum += nums[i];
            let mut left_sum = curr_sum;
            let mut right_sum = total_sum - curr_sum;
            if nums[i] != 0 {
                continue;
            }
            if left_sum == right_sum {
                result += 2;
            } else if (left_sum - right_sum).abs() == 1 {
                result += 1;
            }
        }
        return result;
    }
}