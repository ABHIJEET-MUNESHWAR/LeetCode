func stringMatching(words []string) []string {
	result := []string{}

	for i, pattern := range words {
		for j, text := range words {
			if i == j {
				continue
			}
			if pattern == text || KMPSearch(text, pattern) {
				result = append(result, pattern)
				break
			}
		}
	}

	return result
}

func KMPSearch(text, pattern string) bool {
	pi := computePrefixFunction(pattern)
	j := 0

	for i := 0; i < len(text); i++ {
		for j > 0 && pattern[j] != text[i] {
			j = pi[j-1]
		}
		if text[i] == pattern[j] {
			j++
		}
		if j == len(pattern) {
			return true
		}
	}

	return false
}

func computePrefixFunction(pattern string) []int {
	if len(pattern) == 0 {
		return []int{}
	}
	pi := make([]int, len(pattern))
	pi[0] = 0

	j := 0
	for i := 1; i < len(pattern); i++ {
		for j > 0 && pattern[i] != pattern[j] {
			j = pi[j-1]
		}

		if pattern[i] == pattern[j] {
			j++
		}
		pi[i] = j
	}

	return pi
}