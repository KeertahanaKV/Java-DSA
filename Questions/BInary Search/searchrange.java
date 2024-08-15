import java.util.*;
class Search {
    public static void main(String[] args) {
        int[] a={5,7,7,7,8,8,8,9};
        int target=7;
       int ans[]={-1,-1};
       //to find the first index;
      ans[0]=BS(a,target,true);
       //to find the second index
       if(a[0]!=0)
       {
          ans[1]=BS(a,target,false);
       }
      
       System.out.println(Arrays.toString(ans));
    }
    private static int BS(int[] arr,int target,boolean index)
    {
        int ans=-1;
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
        int mid=start+(end-start)/2;
        if(target < arr[mid])
          end=mid-1;
        else if(target > arr[mid])
        start=mid+1;
        else{
            ans=mid;
           if(index)
           end=mid-1;
           else
           start=mid+1;
        }
        }
        return ans;
    }
}
