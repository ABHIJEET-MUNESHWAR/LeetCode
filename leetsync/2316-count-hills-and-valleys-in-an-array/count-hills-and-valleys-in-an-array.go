func countHillValley(nums []int) int {
	n, count, left, right := len(nums), 0, 0, 0
	for right+1 < n {
		isValley := nums[left] > nums[right] && nums[right] < nums[right+1]
		isHill := nums[left] < nums[right] && nums[right] > nums[right+1]

		if isValley || isHill {
			count++
			left = right
		}
		right++
	}
	return count
}