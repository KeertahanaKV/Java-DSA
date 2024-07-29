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
