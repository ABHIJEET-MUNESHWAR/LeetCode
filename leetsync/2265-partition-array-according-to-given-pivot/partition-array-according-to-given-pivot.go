func pivotArray(nums []int, pivot int) []int {
	n := len(nums)
	result := make([]int, n)
	left, right := 0, n-1
	i, j := 0, n-1
	for i < n && j >= 0 {
		if nums[i] < pivot {
			result[left] = nums[i]
			left++
		}
		if nums[j] > pivot {
			result[right] = nums[j]
			right--
		}
		i++
		j--
	}
	// Fill pivot in the remaining positions
	for left <= right {
		result[left] = pivot
		left++
	}
	return result
}