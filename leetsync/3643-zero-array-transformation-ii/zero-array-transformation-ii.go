func minZeroArray(nums []int, queries [][]int) int {
	isAllZero := true
	for _, num := range nums {
		if num != 0 {
			isAllZero = false
			break
		}
	}
	if isAllZero {
		return 0
	}
	result := -1
	q := len(queries)
	left := 0
	right := q - 1
	for left <= right {
		mid := left + (right-left)/2
		if checkWithDifferenceArray(nums, queries, mid) {
			result = mid + 1
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return result
}
func checkWithDifferenceArray(nums []int, queries [][]int, mid int) bool {
	n := len(nums)
	diff := make([]int, n)
	for i := 0; i <= mid; i++ {
		start := queries[i][0]
		end := queries[i][1]
		value := queries[i][2]
		diff[start] += value
		if end < n-1 {
			diff[end+1] -= value
		}
	}
	prefixSum := 0
	for i := 0; i < n; i++ {
		prefixSum += diff[i]
		diff[i] = prefixSum
		if (nums[i] - diff[i]) > 0 {
			return false
		}
	}
	return true
}