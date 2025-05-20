func isZeroArray(nums []int, queries [][]int) bool {
	n := len(nums)
	diff := make([]int, n)
	for _, query := range queries {
		start := query[0]
		end := query[1]
		x := 1
		diff[start] += x
		if end+1 < n {
			diff[end+1] -= x
		}
	}
	result := make([]int, n)
	cumSum := 0
	for i := 0; i < n; i++ {
		cumSum += diff[i]
		result[i] = cumSum
	}
	for i := 0; i < n; i++ {
		if result[i] < nums[i] {
			return false
		}
	}
	return true
}