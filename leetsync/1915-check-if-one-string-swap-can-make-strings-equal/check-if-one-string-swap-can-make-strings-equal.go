func areAlmostEqual(s1 string, s2 string) bool {
	n := len(s1)
	diffCount := 0
	for i := 0; i < n; i++ {
		if s1[i] != s2[i] {
			diffCount++
		}
		if diffCount > 2 {
			return false
		}
	}
	first := make([]int, 26)
	second := make([]int, 26)
	for i := 0; i < n; i++ {
		first[s1[i]-'a']++
		second[s2[i]-'a']++
	}
	for i := 0; i < 26; i++ {
		if first[i] != second[i] {
			return false
		}
	}
	return true
}