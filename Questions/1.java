//Given an array nums of integer,return how many of them conatins an even number of digits
class EvenDigits
{
    public static void main(String[] args)
    {
        int nums[]={12,345,2,6,-7890,1000,99,0};
        System.out.println(findNumbers(nums));
    }
    static int findNumbers(int[] nums)
    {
        int count=0;
        for(int n:nums)
        {
            if(even(n))
            count++;
        }
        return count;
    }
    static boolean even(int n)
    {
        int digit=evendigit(n);
        return digit % 2 == 0;
    }
    static int evendigit(int n)
    {
        if(n<0)
        {
            n=n*-1;
        }
        else if(n==0)
        return 0;
        
    
        
        return (int)(Math.log10(n)+1);
        /* OR
        int count;
        while(n>0)
        {
            count++;
            n=n%10;
        }*/
        
        
        
    }
}
