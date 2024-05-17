import java.util.*;
public class Main {
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
        int m,n,sum=0;
         System.out.println("Enter the value of n: ");
        n=sc.nextInt();
         System.out.println("enter the value of m: ");
        m=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            if(i%m!=0)
            {
                sum+=i;
            }
            else
            {
                sum-=i;
            }
        }
        System.out.println(sum);
    }
}
