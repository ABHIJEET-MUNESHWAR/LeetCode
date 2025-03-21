func maxAbsoluteSum(nums []int) int {
	n := len(nums)
	currSumMax := nums[0]
	currSumMin := nums[0]
	maxSum := nums[0]
	minSum := nums[0]
	for i := 1; i < n; i++ {
		currSumMax = maxInt(nums[i], currSumMax+nums[i])
		maxSum = maxInt(maxSum, currSumMax)

		currSumMin = minInt(nums[i], currSumMin+nums[i])
		minSum = minInt(minSum, currSumMin)
	}
	return maxInt(maxSum, absInt(minSum))
}
func minInt(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
func maxInt(a, b int) int {
	if a < b {
		return b
	} else {
		return a
	}
}

func absInt(a int) int {
	if a < 0 {
		return -a
	}
	return a
}