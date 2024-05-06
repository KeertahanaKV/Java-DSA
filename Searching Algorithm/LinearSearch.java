import java.util.*;
class LinearSearch{
    public static void main(String[] args)
    {
        int n,arr[];
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the number of elements: ");
        n=sc.nextInt();
        arr = new int[n];
        System.out.print("enter the elements: ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.print("enter the element to Search: ");
        int element=sc.nextInt();
        for(int i=0;i<arr.length;i++)
        {
            if(element==arr[i])
            {
              System.out.println("The element "+arr[i]+" found at pos "+i);
               System.exit(0); 
            }
        }
        System.out.println("Element not Found");
        
    }
}
