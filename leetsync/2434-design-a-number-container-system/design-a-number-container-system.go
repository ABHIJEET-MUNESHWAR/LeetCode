type minHeap []int
func (h minHeap) Less(i,j int) bool{return h[i]<h[j]}
func (h minHeap) Len() int{return len(h)}
func (h minHeap) Swap(i,j int){h[i],h[j]=h[j],h[i]}
func (h *minHeap) Push(x any){
    *h=append(*h,x.(int))
}
func (h *minHeap) Pop() any{
    x:=(*h)[len(*h)-1]
    *h=(*h)[:len(*h)-1]
    return x
}

type NumberContainers struct {
    numToIds map[int]*minHeap
    idToNum map[int]int
}


func Constructor() NumberContainers {
    return NumberContainers{make(map[int]*minHeap),make(map[int]int)}
}


func (this *NumberContainers) Change(index int, number int)  {
    this.idToNum[index]=number
    if this.numToIds[number]==nil{
        this.numToIds[number]=new(minHeap)
    }
    heap.Push(this.numToIds[number],index)
}


func (this *NumberContainers) Find(number int) int {
    if this.numToIds[number]==nil{
        return -1
    }
    for this.numToIds[number].Len()!=0{
        cur:=(*this.numToIds[number])[0]
        if this.idToNum[cur]==number{
            return cur
        }
        _=heap.Pop(this.numToIds[number]).(int)
    }
    return -1
}


/**
 * Your NumberContainers object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Change(index,number);
 * param_2 := obj.Find(number);
 */