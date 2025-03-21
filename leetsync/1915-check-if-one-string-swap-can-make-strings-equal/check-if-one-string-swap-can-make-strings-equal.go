func areAlmostEqual(s1 string, s2 string) bool {
	n := len(s1)
	diffCount := 0
	firstMismatch, secondMismatch := 0, 0
	for i := 0; i < n; i++ {
		if s1[i] != s2[i] {
			diffCount++
			if diffCount > 2 {
				return false
			} else if diffCount == 1 {
				firstMismatch = i
			} else if diffCount == 2 {
				secondMismatch = i
			}
		}
	}
	if s1[firstMismatch] == s2[secondMismatch] && s1[secondMismatch] == s2[firstMismatch] {
		return true
	}
	return false
}