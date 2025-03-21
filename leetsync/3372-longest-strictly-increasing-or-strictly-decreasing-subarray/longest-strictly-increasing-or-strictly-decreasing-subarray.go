func longestMonotonicSubarray(nums []int) int {
	n := len(nums)
	currAsc, currDesc, maxLen := 1, 1, 1
	for i := 0; i < n-1; i++ {
		if nums[i] < nums[i+1] {
			currAsc++
			currDesc = 1
		} else if nums[i] > nums[i+1] {
			currAsc = 1
			currDesc++
		} else {
			currAsc = 1
			currDesc = 1
		}
		maxLen = maxInt(maxLen, maxInt(currAsc, currDesc))
	}
	return maxLen
}
func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}