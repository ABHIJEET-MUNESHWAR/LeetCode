func queryResults(limit int, queries [][]int) []int {
	n := len(queries)
	result := make([]int, 0, n)
	ballToColorMap := map[int]int{}
	colorToFreqMap := map[int]int{}
	for _, query := range queries {
		ball := query[0]
		color := query[1]
		if previousColor, ok := ballToColorMap[ball]; ok {
			colorToFreqMap[previousColor]--
			if colorToFreqMap[previousColor] == 0 {
				delete(colorToFreqMap, previousColor)
			}
		}
		ballToColorMap[ball] = color
		colorToFreqMap[color]++
		result = append(result, len(colorToFreqMap))
	}
	return result
}