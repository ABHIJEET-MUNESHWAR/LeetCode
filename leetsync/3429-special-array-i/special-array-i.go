func isArraySpecial(nums []int) bool {
	n := len(nums)
	for i := 0; i < n-1; i++ {
		if nums[i]%2 == nums[i+1]%2 {
			return false
		}
	}
	return true
}