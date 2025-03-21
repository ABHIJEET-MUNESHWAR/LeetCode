func find(parent []int, i int) int {
	if parent[i] == i {
		return i
	}
	parent[i] = find(parent, parent[i])
	return parent[i]
}
func union(parent []int, rank []int, i, j int) {
	parentOfI, parentOfJ := find(parent, i), find(parent, j)
	if rank[parentOfI] > rank[parentOfJ] {
		parent[parentOfJ] = parent[parentOfI]
	} else if rank[parentOfI] < rank[parentOfJ] {
		parent[parentOfI] = parent[parentOfJ]
	} else {
		parent[parentOfI] = parent[parentOfJ]
		rank[parentOfJ]++
	}
}

func findRedundantConnection(edges [][]int) []int {
	n := len(edges)
	parent := make([]int, n+1)
	rank := make([]int, n+1)
	for i := 0; i < n; i++ {
		parent[i] = i
		rank[i] = 0
	}
	for _, edge := range edges {
		u, v := edge[0], edge[1]
		if find(parent, u) == find(parent, v) {
			return edge
		}
		union(parent, rank, u, v)
	}
	return []int{}
}