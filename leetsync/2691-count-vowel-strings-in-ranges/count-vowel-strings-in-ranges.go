func vowelStrings(words []string, queries [][]int) []int {
	wordsLen := len(words)
	prefixArray := make([]int, wordsLen)
	sum := 0
	for i := 0; i < wordsLen; i++ {
		word := words[i]
		if isWordStartEndWithVowel(word) {
			sum++
		}
		prefixArray[i] = sum
	}
	queriesLen := len(queries)
	result := make([]int, queriesLen)
	for i := 0; i < queriesLen; i++ {
		l := queries[i][0]
		r := queries[i][1]
		left := 0
		if l > 0 {
			left = prefixArray[l-1]
		}
		result[i] = prefixArray[r] - left
	}
	return result
}
func isWordStartEndWithVowel(word string) bool {
	first := word[0]
	last := word[len(word)-1]
	return isVowel(first) && isVowel(last)
}

func isVowel(ch byte) bool {
	return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
}