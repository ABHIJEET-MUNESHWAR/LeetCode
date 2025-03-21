func findMissingAndRepeatedValues(grid [][]int) []int {
	n := len(grid)
	N := n * n
	gridSum := 0
	gridSqSum := 0
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			gridSum += grid[i][j]
			gridSqSum += grid[i][j] * grid[i][j]
		}
	}
	sum := (N * (N + 1)) / 2
	sqSum := (N * (N + 1) * (2*N + 1)) / 6

	sumDiff := gridSum - sum
	sqDiff := gridSqSum - sqSum

	a := (sqDiff/sumDiff + sumDiff) / 2
	b := (sqDiff/sumDiff - sumDiff) / 2
	return []int{a, b}
}