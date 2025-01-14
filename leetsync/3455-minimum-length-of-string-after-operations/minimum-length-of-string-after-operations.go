func minimumLength(s string) int {
	freq := make([]int, 26)
	n := len(s)
	deletedChars := 0
	for i := 0; i < n; i++ {
		chInt := s[i] - 'a'
		freq[chInt]++
		if freq[chInt] == 3 {
			freq[chInt] = 1
			deletedChars += 2
		}
	}
	return n - deletedChars
}