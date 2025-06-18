func divideArray(nums []int, k int) [][]int {
	n := len(nums)
	result := make([][]int, 0)
	sort.Ints(nums)
	for i := 0; i < n; i += 3 {
		if nums[i+2]-nums[i] > k {
			return [][]int{}
		} else {
			result = append(result, []int{nums[i], nums[i+1], nums[i+2]})
		}
	}
	return result
}