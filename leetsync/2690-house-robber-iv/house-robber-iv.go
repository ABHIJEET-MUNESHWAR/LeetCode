func minCapability(nums []int, k int) int {
	left := math.MaxInt32
	right := 0
	for _, num := range nums {
		left = min(left, num)
		right = max(right, num)
	}
	result := right
	for left <= right {
		mid := left + (right-left)/2
		if isPossibleToRob(nums, k, mid) {
			result = mid
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return result
}
func isPossibleToRob(nums []int, k int, mid int) bool {
	n := len(nums)
	house := 0
	for i := 0; i < n; i++ {
		if nums[i] <= mid {
			house++
			i++
		}
	}
	return house >= k
}