
package main

import "fmt"

func generateString(n int, current string, happyStrings *[]string) {
    if len(current) == n {
        *happyStrings = append(*happyStrings, current)
        return
    }

    for _, ch := range []rune{'a', 'b', 'c'} {
        if len(current) > 0 && current[len(current)-1] == byte(ch) {
            continue
        }
        generateString(n, current+string(ch), happyStrings)
    }
}

func getHappyString(n int, k int) string {
    var happyStrings []string
    generateString(n, "", &happyStrings)
    
    if len(happyStrings) < k {
        return ""
    }
    return happyStrings[k-1]
}