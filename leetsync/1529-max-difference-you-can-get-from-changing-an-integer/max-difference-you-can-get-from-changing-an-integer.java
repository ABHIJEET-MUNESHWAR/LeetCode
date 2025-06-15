class Solution {
    public int maxDiff(int num) {
        String str1 = Integer.toString(num);
        String str2 = str1;

        // Create max number by replacing first non-9 digit with 9
        int n = str1.length();
        int index = -1;
        for (int i = 0; i < n; i++) {
            char ch = str1.charAt(i);
            if (ch != '9') {
                index = i;
                break;
            }
        }
        if (index != -1) {
            char ch = str1.charAt(index);
            str1 = str1.replace(ch, '9');
        }

        // Create min number with care to avoid leading zeros
        for (int i = 0; i < n; i++) {
            char ch = str2.charAt(i);
            if (i == 0) {
                if (ch != '1') {
                    str2 = str2.replace(ch, '1');
                    break;
                }
            } else if (ch != '0' && ch != str2.charAt(0)) {
                str2 = str2.replace(ch, '0');
                break;
            }
        }
        return Integer.parseInt(str1) - Integer.parseInt(str2);
    }
}