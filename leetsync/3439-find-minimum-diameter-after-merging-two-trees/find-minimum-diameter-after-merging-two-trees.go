// Helper function to calculate the diameter of a tree using DFS
func getDiameter(curr int, paths [][]int, visited []bool, d *int) int {
	visited[curr] = true
	max1, max2 := 0, 0

	for _, neighbor := range paths[curr] {
		if !visited[neighbor] {
			depth := getDiameter(neighbor, paths, visited, d)
			if depth >= max1 {
				max2 = max1
				max1 = depth
			} else if depth > max2 {
				max2 = depth
			}
		}
	}

	// Update the diameter at the current node
	*d = max(*d, max1+max2)
	return max1 + 1
}

// Main function to find the minimum diameter after merging two trees
func minimumDiameterAfterMerge(edges1, edges2 [][]int) int {
	// Calculate the diameter of the first tree
	n := len(edges1) + 1
	paths1 := make([][]int, n)
	for _, edge := range edges1 {
		paths1[edge[0]] = append(paths1[edge[0]], edge[1])
		paths1[edge[1]] = append(paths1[edge[1]], edge[0])
	}
	visited := make([]bool, n)
	d1 := 0
	getDiameter(0, paths1, visited, &d1)

	// Calculate the diameter of the second tree
	m := len(edges2) + 1
	paths2 := make([][]int, m)
	for _, edge := range edges2 {
		paths2[edge[0]] = append(paths2[edge[0]], edge[1])
		paths2[edge[1]] = append(paths2[edge[1]], edge[0])
	}
	visited = make([]bool, m)
	d2 := 0
	getDiameter(0, paths2, visited, &d2)

	// Calculate the new diameter after merging
	d3 := int(math.Ceil(float64(d1)/2) + math.Ceil(float64(d2)/2) + 1)

	return max(d3, max(d1, d2))
}

// Utility function to find the maximum of two integers
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}