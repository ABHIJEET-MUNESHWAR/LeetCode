func countSubarrays(nums []int, k int64) int64 {
	n := len(nums)
	result, sum := 0, 0
	left, right := 0, 0
	for right < n {
		sum += nums[right]
		for left <= right && (sum*(right-left+1) >= int(k)) {
			sum -= nums[left]
			left++
		}
		result += (right - left + 1)
		right++
	}
	return int64(result)
}