func maxCount(banned []int, n int, maxSum int) int {

	bannedMap := make(map[int]bool)
	for i := 0; i < len(banned); i++ {
		bannedMap[banned[i]] = true
	}
	sum, count := 0, 0
	for i := 1; i <= n; i++ {
		if _, ok := bannedMap[i]; ok {
			continue
		}
		sum += i
		if sum > maxSum {
			return count
		}
		count++
	}
	return count
}