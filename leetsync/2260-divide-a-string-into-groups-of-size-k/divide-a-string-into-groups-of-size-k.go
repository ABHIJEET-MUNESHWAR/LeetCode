func divideString(s string, k int, fill byte) []string {
	for len(s)%k != 0 {
		s += string(fill)
	}
	n := len(s)
	var result []string
	for i := 0; i < n; i += k {
		result = append(result, s[i:i+k])
	}
	return result
}