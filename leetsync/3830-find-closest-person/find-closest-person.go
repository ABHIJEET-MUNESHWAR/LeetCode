func findClosest(x int, y int, z int) int {
	dist1 := AbsInt(x - z)
	dist2 := AbsInt(z - y)
	if dist1 == dist2 {
		return 0
	} else if dist1 < dist2 {
		return 1
	} else {
		return 2
	}
}
func AbsInt(x int) int {
	if x < 0 {
		return -x
	}
	return x
}