func areaOfMaxDiagonal(dimensions [][]int) int {
	n := len(dimensions)
	maxDiagonal, maxArea := 0, 0
	for i := 0; i < n; i++ {
		length := dimensions[i][0]
		width := dimensions[i][1]
		diagonal := length*length + width*width
		area := length * width
		if maxDiagonal < diagonal {
			maxDiagonal = diagonal
			maxArea = area
		} else if maxDiagonal == diagonal {
			maxArea = max(maxArea, area)
		}
	}
	return maxArea
}