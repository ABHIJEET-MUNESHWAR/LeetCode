func findWordsContaining(words []string, x byte) []int {
	result := make([]int, 0, len(words))
	j := 0
	for _, word := range words {
		n := len(word)
		for i := 0; i < n; i++ {
			if word[i] == x {
				result = append(result, j)
				break
			}
		}
		j++
	}
	return result
}