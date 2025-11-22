impl Solution {
    pub fn minimum_operations(nums: Vec<i32>) -> i32 {
        let mut count: i32 = 0;
        for num in nums {
            match num % 3 {
                1 => count += 1,
                2 => count += 1,
                _ => {}
            }
        }

        count
    }
}