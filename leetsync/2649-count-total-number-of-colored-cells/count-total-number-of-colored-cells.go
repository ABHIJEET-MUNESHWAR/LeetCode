func coloredCells(n int) int64 {
	time := 1
	cells := 1
	for time <= n {
		cells = cells + (4 * (time - 1))
		time++
	}
	return int64(cells)
}