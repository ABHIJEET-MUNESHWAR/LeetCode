func stringMatching(words []string) []string {
	n := len(words)
	wordSet := make(map[string]struct{})
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if i == j {
				continue
			}
			if strings.Contains(words[i], words[j]) {
				wordSet[words[j]] = struct{}{}
			}
		}
	}
	var result []string

	for k, _ := range wordSet {
		result = append(result, k)
	}
	return result
}