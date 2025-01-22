func highestPeak(isWater [][]int) [][]int {
	m := len(isWater)
	n := len(isWater[0])
	height := make([][]int, 0)
	queue := [][2]int{}
	for i := 0; i < m; i++ {
		height = append(height, make([]int, len(isWater[0])))
		for j := 0; j < n; j++ {
			if isWater[i][j] == 1 {
				height[i][j] = 0
				queue = append(queue, [2]int{i, j})
			} else {
				height[i][j] = -1
			}
		}
	}
	directions := [][2]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	for len(queue) > 0 {
		x := queue[0][0]
		y := queue[0][1]
		queue = queue[1:]
		for _, direction := range directions {
			nx, ny := x+direction[0], y+direction[1]
			if nx >= 0 && ny >= 0 && nx < m && ny < n && height[nx][ny] == -1 {
				height[nx][ny] = height[x][y] + 1
				queue = append(queue, [2]int{nx, ny})
			}
		}
	}
	return height
}