func setZeroes(matrix [][]int) {
	m := len(matrix)
	n := len(matrix[0])
	isFirstRowZero := false
	isFirstColZero := false
	for i := 0; i < m; i++ {
		if matrix[i][0] == 0 {
			isFirstColZero = true
			break
		}
	}
	for j := 0; j < n; j++ {
		if matrix[0][j] == 0 {
			isFirstRowZero = true
			break
		}
	}
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			if matrix[i][j] == 0 {
				matrix[i][0] = 0
				matrix[0][j] = 0
			}
		}
	}
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			if matrix[i][0] == 0 || matrix[0][j] == 0 {
				matrix[i][j] = 0
			}
		}
	}
	if isFirstRowZero {
		for j := 0; j < n; j++ {
			matrix[0][j] = 0
		}
	}
	if isFirstColZero {
		for i := 0; i < m; i++ {
			matrix[i][0] = 0
		}
	}
}