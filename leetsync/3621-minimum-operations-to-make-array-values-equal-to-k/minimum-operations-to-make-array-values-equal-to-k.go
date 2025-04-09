func minOperations(nums []int, k int) int {
	set := make(map[int]struct{})
	for _, num := range nums {
		if num < k {
			return -1
		} else if num > k {
			set[num] = struct{}{}
		}
	}
	return len(set)
}