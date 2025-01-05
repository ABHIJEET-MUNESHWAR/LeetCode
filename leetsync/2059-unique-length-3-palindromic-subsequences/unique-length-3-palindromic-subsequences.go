func countPalindromicSubsequence(s string) int {
	order := make([][2]int, 26)
	for i := range order {
		order[i] = [2]int{-1, -1}
	}
	for i, char := range s {
		index := char - 'a'
		if order[index][0] == -1 {
			order[index][0] = i
		} else {
			order[index][1] = i
		}
	}
	count := 0
	for _, pos := range order {
		if pos[1]-pos[0] > 1 {
			unique := make(map[rune]struct{})
			for _, midChar := range s[pos[0]+1 : pos[1]] {
				unique[midChar] = struct{}{}
			}
			count += len(unique)
		}
	}
	return count
}