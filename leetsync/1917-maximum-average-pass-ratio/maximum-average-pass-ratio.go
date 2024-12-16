type element struct {
	avg   float64
	index int
}

type pq []*element

func (c pq) Len() int {
	return len(c)
}

func (c pq) Less(i, j int) bool {
	return c[i].avg > c[j].avg
}

func (c pq) Swap(i, j int) {
	c[i], c[j] = c[j], c[i]
}

func (c *pq) Push(x interface{}) {
	*c = append(*c, x.(*element))
}

func (c *pq) Pop() interface{} {
	n := len(*c)
	x := (*c)[n-1]
	*c = (*c)[:n-1]
	return x
}

func calAvg(c []int) float64 {
	return float64(c[0]+1)/float64(c[1]+1) - float64(c[0])/float64(c[1])
}

func maxAverageRatio(classes [][]int, extraStudents int) float64 {
	h := pq{}
	for i, c := range classes {
		heap.Push(&h, &element{
			avg:   calAvg(c),
			index: i,
		})
	}
	for i := 0; i < extraStudents; i++ {
		c := heap.Pop(&h).(*element)
		classes[c.index][0]++
		classes[c.index][1]++
		c.avg = calAvg(classes[c.index])
		heap.Push(&h, c)
	}
	var sum float64
	for _, c := range classes {
		sum += float64(c[0]) / float64(c[1])
	}
	return sum / float64(len(classes))
}