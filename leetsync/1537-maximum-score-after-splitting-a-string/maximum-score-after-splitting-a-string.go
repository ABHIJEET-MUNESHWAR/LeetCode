func maxScore(s string) int {
	n := len(s)
	zeros, ones := 0, 0
	for _, v := range s {
		if v == '1' {
			ones++
		}
	}
	result := 0
	for i := 0; i < n-1; i++ {
		if s[i] == '0' {
			zeros++
		} else {
			ones--
		}
		result = max(result, zeros+ones)
	}
	return result
}