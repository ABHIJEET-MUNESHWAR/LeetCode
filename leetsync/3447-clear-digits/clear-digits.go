func clearDigits(s string) string {
	n := len(s)
	result := ""
	for i := 0; i < n; i++ {
		ch := s[i]
		if ch >= '0' && ch <= '9' {
			result = result[:len(result)-1]
		} else {
			result = result + string(ch)
		}
	}
	return result
}