func largestGoodInteger(num string) string {
	n := len(num)
	maxChar := ""
	for i := 0; i < n-2; i++ {
		if num[i] == num[i+1] && num[i] == num[i+2] {
			current := num[i : i+3]
			if maxChar < current {
				maxChar = current
			}
		}
	}
	return maxChar
}