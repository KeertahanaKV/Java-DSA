//reset and set the it bit 
import java.util.Scanner;

class SetReset {
    public static void main(String[] args) {
        int i;
        Scanner sc = new Scanner(System.in);
        int n = 0b1010101001;  // Binary representation of the number
        System.out.println("Initial number in binary: " + Integer.toBinaryString(n));
        System.out.println("Enter 1 to set the bit\nEnter 2 to reset the bit");
        int a = sc.nextInt();
        switch(a) {
            case 1:
                System.out.println("Enter the ith bit to set:");
                i = sc.nextInt();
                int setResult = set(n, i);
                System.out.println("Result after setting the bit: " + Integer.toBinaryString(setResult));
                break;
            case 2:
                System.out.println("Enter the ith bit to reset:");
                i = sc.nextInt();
                int resetResult = reset(n, i);
                System.out.println("Result after resetting the bit: " + Integer.toBinaryString(resetResult));
                break;
        }
        sc.close();
    }

    public static int set(int n, int i) {
        return n | (1 << (i - 1));
    }

    public static int reset(int n, int i) {
        return n & ~(1 << (i - 1));
    }
}
