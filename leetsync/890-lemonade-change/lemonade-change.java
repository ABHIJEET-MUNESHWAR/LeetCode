class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five = 0, ten = 0;
        for (int i = 0; i < n; i++) {
            int bill = bills[i];
            switch (bill) {
                case 5:
                    five++;
                    break;
                case 10:
                    if (five > 0) {
                        ten++;
                        five--;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if (five > 0 && ten > 0) {
                        five--;
                        ten--;
                    } else if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}