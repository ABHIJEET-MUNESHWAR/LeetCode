func maxAdjacentDistance(nums []int) int {
	n := len(nums)
	maxDiff := 0
	for i := 0; i < n; i++ {
		maxDiff = max(maxDiff, abs(nums[i]-nums[(i+1)%n]))
	}
	return maxDiff
}
func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}