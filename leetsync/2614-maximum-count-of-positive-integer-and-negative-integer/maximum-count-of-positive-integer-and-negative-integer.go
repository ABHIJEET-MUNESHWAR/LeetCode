func maximumCount(nums []int) int {
	positives, negatives := 0, 0
	for _, num := range nums {
		if num > 0 {
			positives++
		} else if num < 0 {
			negatives++
		}
	}
	return max(positives, negatives)
}