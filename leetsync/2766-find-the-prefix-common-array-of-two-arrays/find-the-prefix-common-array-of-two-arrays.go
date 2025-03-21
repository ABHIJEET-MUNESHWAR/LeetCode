func findThePrefixCommonArray(a []int, b []int) []int {
	n := len(a)
	result := make([]int, n)
	visited := make([]int, n+1)
	currentCount := 0
	for i := 0; i < n; i++ {
		visited[a[i]]++
		if visited[a[i]] == 2 {
			currentCount++
		}
		visited[b[i]]++
		if visited[b[i]] == 2 {
			currentCount++
		}
		result[i] = currentCount
	}
	return result
}