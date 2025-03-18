
func longestNiceSubarray(nums []int) int {
	n := len(nums)
	left, right, result, mask := 0, 0, 1, 0
	for right < n {
		for (mask & nums[right]) != 0 {
			mask = (mask ^ nums[left])
			left++
		}
		result = max(result, right-left+1)
		mask = (mask | nums[right])
		right++
	}
	return result
}