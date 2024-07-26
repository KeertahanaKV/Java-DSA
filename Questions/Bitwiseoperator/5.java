public class RightmostSetBit {
    public static int findRightmostSetBitPosition(int n) {
        if (n == 0) {
            return 0; // No set bits in 0
        }

        // Isolate the rightmost set bit
        int isolatedBit = n & -n;

        // Calculate the position of the isolated bit
        int position = (int) (Math.log(isolatedBit) / Math.log(2)) + 1;

        
  /*        // Count the position of the isolated bit
        while (isolatedBit > 1) {
            isolatedBit >>= 1; // Shift right to move to the next bit
            position++; */
        }


        return position;
    }

    public static void main(String[] args) {
       int n = 101010100;  // Binary representation of the number
        int position = findRightmostSetBitPosition(n);
        System.out.println("The position of the rightmost set bit is: " + position);
    }
}
