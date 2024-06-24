//Given an array of numbers and every number appears twice only one number appears once
import java.util.Scanner;

class BitwiseOperator {
    public static void main(String args[]) {
        int[] arr={2,3,4,1,2,1,3,6,4};
       System.out.println(ans(arr));
        }
    
    
    private static int ans(int[] arr) {
        int unique=0;
        for(int n:arr)
        {
            unique^=n;
        }
        return unique;
    }
}
