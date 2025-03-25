func minOperations(nums []int) int {
	n := len(nums)
	k := 3
	isFlipped := make([]bool, n)
	totalFlips := 0
	flipCountFromPastForCurrentI := 0
	for i := 0; i < n; i++ {
		if i >= k && isFlipped[i-k] {
			flipCountFromPastForCurrentI--
		}
		if flipCountFromPastForCurrentI%2 == nums[i] {
			if (i + k) > n {
				return -1
			}
			totalFlips++
			isFlipped[i] = true
			flipCountFromPastForCurrentI++
		}
	}
	return totalFlips
}