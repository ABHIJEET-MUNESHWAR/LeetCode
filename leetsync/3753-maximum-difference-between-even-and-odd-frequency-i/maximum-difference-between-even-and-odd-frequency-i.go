import "math"

func maxDifference(s string) int {
    freq := make([]int, 26)
    a := 'a'

    for _, ch := range s {
        freq[ch-a]++
    }

    odd := 0
    even := math.MaxInt32

    for _, n := range freq {
        if n%2 == 1 {
            if n > odd {
                odd = n
            }
        } else if n != 0 && n < even {
            even = n
        }
    }

    if even == math.MaxInt32 {
        return odd
    }
    return odd - even
}