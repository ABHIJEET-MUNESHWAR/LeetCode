func countSubarrays(nums []int, k int) int64 {
	n := len(nums)
	left, right, max, maxFreq := 0, 0, 0, 0
	result := 0
	for _, num := range nums {
		if max < num {
			max = num
		}
	}
	for right < n {
		if nums[right] == max {
			maxFreq++
		}
		for maxFreq >= k {
			result += n - right
			if nums[left] == max {
				maxFreq--
			}
			left++
		}
		right++
	}
	return int64(result)
}