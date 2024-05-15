//Given an m*n integer grid accounts[i][j] is the amount of money the ith customer has in the jth bank,Return the wealth of the richest customer.

class MaxWealth {
    public static void main(String[] args) {
        int[][] accounts={{1,5},{7,3},{3,5}};
        System.out.println("The Wealth of the richest customer: "+maximumWealth(accounts));
        
    }
    public static int maximumWealth(int[][] accounts)
    {
       //rows = person and column = accounts
        int max=Integer.MIN_VALUE;
       
        for(int person=0;person<accounts.length;person++)
        {
            int sum=0;
            for(int account=0;account<accounts[person].length;account++)
            {
                sum+=accounts[person][account];
            }
            if(sum>max)
            {
                max=sum;
            }
        }
        
        return max;
    }

}
