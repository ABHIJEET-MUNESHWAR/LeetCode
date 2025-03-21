package main

func maxKDivisibleComponents(n int, edges [][]int, values []int, k int) int {
	adj := make(map[int][]int)
	comp := 0

	// Build adjacency list
	for _, edge := range edges {
		u, v := edge[0], edge[1]
		adj[u] = append(adj[u], v)
		adj[v] = append(adj[v], u)
	}

	var dfs func(node, parent int) int
	dfs = func(node, parent int) int {
		sum := values[node]

		for _, neighbor := range adj[node] {
			if neighbor != parent {
				sum += dfs(neighbor, node)
			}
		}

		if sum%k == 0 {
			comp++
			return 0
		}
		return sum % k
	}

	dfs(0, -1)
	return comp
}