func closestPrimes(left int, right int) []int {
	isPrime := sieveHelper(right)
	primes := []int{}

	for num := left; num <= right; num++ {
		if isPrime[num] {
			primes = append(primes, num)
		}
	}
	if len(primes) < 2 {
		return []int{-1, -1}
	}
	minGap := int(^uint(0) >> 1)
	result := []int{-1, -1}
	for i := 1; i < len(primes); i++ {
		gap := primes[i] - primes[i-1]
		if minGap > gap {
			minGap = gap
			result[0] = primes[i-1]
			result[1] = primes[i]
		}
	}
	return result
}

func sieveHelper(right int) []bool {
	sieve := make([]bool, right+1)
	for i := range sieve {
		sieve[i] = true
	}
	sieve[0], sieve[1] = false, false

	for i := 2; i*i <= right; i++ {
		if sieve[i] {
			for j := i * i; j <= right; j += i {
				sieve[j] = false
			}
		}
	}
	return sieve
}