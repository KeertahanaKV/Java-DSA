//find the ith bit of a number
import java.util.Scanner;

class BitwiseOperator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        int n = 680; // decimal representation of 1010101000 in binary
        System.out.println("Enter the index:");
        i = sc.nextInt();
        System.out.println("The bit at index " + i + " is: " + getBit(n, i));
    }
    
    private static int getBit(int n, int i) {
        return (n & (1 << i)) >> i;
       // This shifts the result back to the right by i positions, moving the ith bit to the least significant bit position.
        //This results in either 0 or 1, depending on the value of the ith bit.
       //or  return (n >> (i - 1)) & 1;
    }
}
