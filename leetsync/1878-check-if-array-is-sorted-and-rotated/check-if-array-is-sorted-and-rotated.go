func check(nums []int) bool {
	n := len(nums)
	k := 0
	for i := 0; i < n; i++ {
		if nums[i] > nums[(i+1)%n] {
			k++
		}
		if k > 1 {
			return false
		}
	}
	return true
}