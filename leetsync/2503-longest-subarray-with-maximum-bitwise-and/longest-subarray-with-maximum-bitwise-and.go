func longestSubarray(nums []int) int {
	maxLength, streak, maxValue := 0, 0, 0
	for _, num := range nums {
		if maxValue < num {
			maxValue = num
			streak = 0
			maxLength = 0
		}
		if maxValue == num {
			streak++
		} else {
			streak = 0
		}
		maxLength = max(maxLength, streak)
	}
	return maxLength
}