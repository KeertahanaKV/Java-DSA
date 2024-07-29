class Power {
    public static void main(String[] args) {
        double base = 5;
        int power = -5; // Example of a negative power
        double ans = 1;

        // Handle negative power
        if (power < 0) {
            base = 1 / base;
            power*=-1;//power=-power
        }

        while (power > 0) {
            if ((power & 1) == 1) {
                ans *= base;
            }
            base *= base;
            power = power >> 1;
        }
        
        System.out.println(ans);
    }
}
/* By using recurrsion
class Power {
    public static void main(String args[]) {
        double x = 4.0;
        long n = 4;
        System.out.println(pow(x, n));
    }

    private static double pow(double base, long p) {
        if (p == 0) return 1.0;
        if (p == 1) return base;
        if (p < 0) return pow(1 / base, -p);

        double res = pow(base, p / 2);
        res *= res; // Square the result for the even case
        
        if (p % 2 == 1) {
            res *= base; // Handle odd case
        }
        
        return res;
    }
}
*/
