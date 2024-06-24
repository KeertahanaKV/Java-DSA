import java.util.Scanner;

class BitwiseOperator {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        boolean result;
        
        System.out.println("Enter the value of n to find odd or even");
        n = sc.nextInt();
        
        result = isOdd(n); 
        
        if (result) {
            System.out.println(n + " is odd.");
        } else {
            System.out.println(n + " is even.");
        }
    }
    
    private static boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}
