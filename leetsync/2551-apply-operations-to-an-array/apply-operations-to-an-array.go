func applyOperations(nums []int) []int {
	n := len(nums)
	j := 0
	for i := 0; i < n; i++ {
		if (i+1) < n && nums[i] == nums[i+1] && nums[i] != 0 {
			nums[i] = 2 * nums[i]
			nums[i+1] = 0
		}
		if nums[i] != 0 {
			if j != i {
				nums[i], nums[j] = nums[j], nums[i]
			}
			j++
		}
	}
	return nums
}