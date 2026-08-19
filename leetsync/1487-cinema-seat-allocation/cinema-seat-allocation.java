class Solution {

    public int maxNumberOfFamilies(int n, int[][] rs) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int[] r : rs) {
            int row = r[0], seat = r[1];
            mp.merge(row, 1 << (10 - seat), (a, b) -> a | b);
        }
        int ans = (n - mp.size()) * 2;
        int[] masks = { 0b0111100000, 0b0000011110, 0b0001111000 };

        for (int x : mp.values()) {
            for (int m : masks) {
                if ((m & x) == 0) {
                    ans++;
                    // set the bits 
                    x |= m;
                }
            }
        }
        return ans;
    }

    public int maxNumberOfFamiliesUsingList(int n, int[][] rs) {
        // How many rows are there in reservesSeats.length -> only for these we have to check 
        // rest all are empty 
        // so we can simply find the grps from them 
        // 10 seats -> we have to choose grp of 4 -> 2 distinct we can have. 
        // 1 & 10 - seat are not included
        HashMap<Integer, List<Integer>> mp = new HashMap<>(); // max length can be 1e4. 
        for (int[] r : rs) {
            // we can always add 1 & 10 
            if (r[1] == 1 || r[1] == 10)
                continue;
            mp.computeIfAbsent(r[0], k -> new ArrayList<>()).add(r[1]);
        }

        int sz = mp.size(); // unique rows in map, 
        int left = n - sz; // left rows which are completely empty 
        int ans = 2 * left; // each row contributes 2 seats. 

        for (Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
            List<Integer> value = entry.getValue();

            boolean block1 = true, block2 = true, block3 = true;
            for (Integer x : value) {
                if (x >= 2 && x <= 5)
                    block1 = false;
                if (x >= 4 && x <= 7)
                    block2 = false;
                if (x >= 6 && x <= 9)
                    block3 = false;
            }

            if (block1 && block3)
                ans += 2;
            else if (block1 || block2 || block3)
                ans += 1;

        }
        ;
        return ans;
    }
}