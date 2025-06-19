func partitionArray(nums []int, k int) int {
	n := len(nums)
	count := 1
	sort.Ints(nums)
	min := nums[0]
	for i := 0; i < n; i++ {
		if (nums[i] - min) > k {
			count++
			min = nums[i]
		}
	}
	return count
}