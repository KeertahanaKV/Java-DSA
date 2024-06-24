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
        return (n >> (i - 1)) & 1;
    }
}
