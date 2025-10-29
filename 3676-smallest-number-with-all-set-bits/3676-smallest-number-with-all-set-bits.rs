impl Solution {
    pub fn smallest_number(n: i32) -> i32 {
        (1 << 32 - n.leading_zeros()) - 1
    }
}