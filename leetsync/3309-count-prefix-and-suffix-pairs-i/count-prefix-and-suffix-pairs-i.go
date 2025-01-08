package main

import (
	"fmt"
	"strings"
)

func isPrefixAndSuffix(a, b string) bool {
	n := len(a)
	if n > len(b) {
		return false
	}
	return strings.HasPrefix(b, a) && strings.HasSuffix(b, a)
}

func countPrefixSuffixPairs(words []string) int {
	n := len(words)
	ans := 0
	for i := 0; i < n-1; i++ {
		for j := i + 1; j < n; j++ {
			if isPrefixAndSuffix(words[i], words[j]) {
				ans++
			}
		}
	}
	return ans
}
