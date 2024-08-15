class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int fiveDollar = 0, tenDollar = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fiveDollar++;
            } else if (bill == 10) {
                if (fiveDollar == 0) {
                    return false;
                }
                fiveDollar--;
                tenDollar++;
            } else { // bill == 20
                if (tenDollar > 0 && fiveDollar > 0) {
                    tenDollar--;
                    fiveDollar--;
                } else if (fiveDollar >= 3) {
                    fiveDollar -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    
       
}
