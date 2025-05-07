
func minTimeToReach(moveTime [][]int) int {
	dirs := [4][2]int{{0, -1}, {1, 0}, {0, 1}, {-1, 0}}
	n, m := len(moveTime), len(moveTime[0])
	d := make([][]int, n)
	a := make([][]bool, n)

	for i := 0; i < n; i++ {
		d[i] = make([]int, m)
		a[i] = make([]bool, m)
		for j := 0; j < m; j++ {
			d[i][j] = math.MaxInt
		}
	}

	d[0][0] = 0
	pq := &MinHeap{Node{x: 0, y: 0, dis: 0}}
	heap.Init(pq)

	for pq.Len() > 0 {
		v := heap.Pop(pq).(Node)

		if a[v.x][v.y] {
			continue
		}
		a[v.x][v.y] = true

		for _, dir := range dirs {
			nx, ny := v.x+dir[0], v.y+dir[1]
			if !isValid(nx, n, ny, m) {
				continue
			}

			dist := max(d[v.x][v.y], moveTime[nx][ny]) + 1
			if d[nx][ny] > dist {
				d[nx][ny] = dist
				heap.Push(pq, Node{x: nx, y: ny, dis: dist})
			}
		}
	}

	return d[n-1][m-1]
}

func isValid(row, numRows, col, numCols int) bool {
	return row >= 0 && row < numRows && col >= 0 && col < numCols
}

type Node struct {
	x, y, dis int
}

type MinHeap []Node

func (h MinHeap) Len() int           { return len(h) }
func (h MinHeap) Less(i, j int) bool { return h[i].dis < h[j].dis }
func (h MinHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *MinHeap) Push(x any) {
	*h = append(*h, x.(Node))
}

func (h *MinHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}