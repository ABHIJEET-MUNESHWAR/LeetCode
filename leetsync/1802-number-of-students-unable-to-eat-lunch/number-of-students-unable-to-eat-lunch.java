class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int zeros = 0;
        int once = 0;
        for (int student : students) {
            if (student == 0) {
                zeros++;
            } else {
                once++;
            }
        }
        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (zeros == 0) {
                    return once;
                }
                zeros--;
            } else {
                if (once == 0) {
                    return zeros;
                }
                once--;
            }
        }
        return 0;
    }
}