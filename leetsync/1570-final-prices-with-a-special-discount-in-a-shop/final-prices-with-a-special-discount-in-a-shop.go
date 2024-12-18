func finalPrices(prices []int) []int {
    stack:=make([]int, 0, len(prices))
    for i, discount:= range prices{
        for len(stack)>0 && discount<=prices[stack[len(stack)-1]]{
            prices[stack[len(stack)-1]]-=discount
            stack=stack[:len(stack)-1]
        }
        stack = append(stack, i)
    }
    return prices
}