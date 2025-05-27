func differenceOfSums(n int, m int) int {
	k := n / m
	return n*(n+1)/2 - m*k*(k+1)
}