func waysToSplitArray(nums []int) int {
	n := len(nums)
	result, totalSum, leftSum, rightSum := 0, 0, 0, 0
	for _, v := range nums {
		totalSum += v
	}
	for i := 0; i < n-1; i++ {
		leftSum += nums[i]
		rightSum = totalSum - leftSum
		if leftSum >= rightSum {
			result++
		}
	}
	return result
}