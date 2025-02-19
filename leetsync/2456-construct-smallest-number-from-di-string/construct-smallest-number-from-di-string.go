func smallestNumber(pattern string) string {
	n := len(pattern)
	num := make([]byte, n+1)
	stack := make([]byte, 0)
	counter := byte('1')
	for i := 0; i <= n; i++ {
		stack = append(stack, counter)
		counter++
		if i == n || pattern[i] == 'I' {
			for len(stack) > 0 {
				top := len(stack) - 1
				num[i-top] = stack[top]
				stack = stack[:top]
			}
		}
	}
	return string(num)
}