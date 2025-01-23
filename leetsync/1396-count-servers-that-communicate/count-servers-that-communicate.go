func countServers(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	answer := 0
	indexRowCount := make([]int, m)
	indexColCount := make([]int, n)
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				indexRowCount[i]++
				indexColCount[j]++
			}
		}
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 && (indexRowCount[i] > 1 || indexColCount[j] > 1) {
				answer++
			}
		}
	}
	return answer
}