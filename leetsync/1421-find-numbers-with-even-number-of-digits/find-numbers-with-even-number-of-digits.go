func findNumbers(nums []int) int {
	count := 0
	for _, num := range nums {
		if num >= 10 && num <= 99 {
			count++
		} else if num >= 1000 && num <= 9999 {
			count++
		} else if num == 100000 {
			count++
		}
	}
	return count
}