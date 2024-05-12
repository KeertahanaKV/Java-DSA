import java.util.*;
class LinearSearch_2D{
    public static void main(String[] args)
    {
        int rows,cols,arr[][];
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the number of Rows: ");
        rows=sc.nextInt();
        System.out.print("enter the number of Column: ");
        cols=sc.nextInt();
        arr = new int[rows][cols];
        System.out.print("enter the elements: ");
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            arr[i][j]=sc.nextInt();
        }
        System.out.print("enter the element to Search: ");
        int element=sc.nextInt();
        
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++){
            if(element==arr[i][j])
            {
              System.out.println("The element "+arr[i][j]+" found at pos "+j);
               System.exit(0); 
            }
            }
        }
        System.out.println("Element not Found");
        
    }
}
