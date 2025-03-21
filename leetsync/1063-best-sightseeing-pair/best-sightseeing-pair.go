func maxScoreSightseeingPair(values []int) int {
	n := len(values)
	result := 0
	x := values[0]
	for j := 1; j < n; j++ {
		y := values[j] - j
		result = max(result, x+y)
		x = max(x, values[j]+j)
	}
	return result
}