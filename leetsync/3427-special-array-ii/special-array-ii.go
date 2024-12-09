func isArraySpecial(nums []int, queries [][]int) []bool {
	n := len(nums)
	prefixSum := make([]int, n)
	// Step 1: Compute prefixSum
	for i := 1; i < n; i++ {
		prefixSum[i] = prefixSum[i-1]
		if (nums[i]%2 == 0 && nums[i-1]%2 != 0) || (nums[i]%2 != 0 && nums[i-1]%2 == 0) {
			prefixSum[i]++
		}
	}
	// Step 2: Process queries
	result := []bool{}
	for _, query := range queries {
		left, right := query[0], query[1]
		totalPairs := right - left
		validPairs := prefixSum[right] - prefixSum[left]
		result = append(result, validPairs == totalPairs)
	}
	return result
}