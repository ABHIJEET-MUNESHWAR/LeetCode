func numberOfAlternatingGroups(colors []int, k int) int {
	colors = append(colors, colors[:k-1]...)
	count := 0
	left := 0
	for right := 0; right < len(colors); right++ {
		if right > 0 && colors[right-1] == colors[right] {
			left = right
		}
		if right-left+1 >= k {
			count++
		}
	}
	return count
}