func maxAscendingSum(nums []int) int {
	n := len(nums)
	maxSum, currentSum := nums[0], nums[0]
	for i := 1; i < n; i++ {
		if nums[i-1] < nums[i] {
			currentSum += nums[i]
		} else {
			currentSum = nums[i]
		}
		maxSum = maxInt(maxSum, currentSum)
	}
	return maxSum
}
func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}