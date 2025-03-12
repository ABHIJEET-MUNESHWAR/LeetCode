func maximumCount(nums []int) int {
	positives, negatives := lowerBound(nums, 1), lowerBound(nums, 0)
	n := len(nums)
	return max(n-positives, negatives)
}
func lowerBound(nums []int, target int) int {
	n := len(nums)
	left, right := 0, n-1
	result := n
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] < target {
			left = mid + 1
		} else {
			result = mid
			right = mid - 1
		}
	}
	return result
}