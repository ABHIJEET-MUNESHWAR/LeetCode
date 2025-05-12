func findEvenNumbers(digits []int) []int {
    freqs := [10]int{};
    even := 0;

    for _, digit := range digits {
        freqs[digit]++;
        if digit % 2 == 0 {
            even++;
        }
    }

    if even == 0 {
        return []int{};
    }

    result := []int{}
    for x := 100; x <= 999; x += 2 {
        freq := freqs;
        x0 := x % 10;
        x1 := (x / 10) % 10;
        x2 := x / 100;

        freq[x0]--;
        if freq[x0] < 0 {
            continue;
        }

        freq[x1]--;
        if freq[x1] < 0 {
            continue;
        }

        freq[x2]--;
        if freq[x2] < 0 {
            continue;
        }

        result = append(result, x);
    }

    return result;
}