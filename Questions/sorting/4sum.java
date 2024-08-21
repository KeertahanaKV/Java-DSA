class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        int l,k;
         long sum=0;
        
        for(int i=0;i<nums.length-3;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            continue;
            for(int j=i+1;j<nums.length-2;j++)
            {
                if(j>i+1 && nums[j]==nums[j-1])
                continue;

                l=j+1;
                 k=nums.length-1;
                 while(l<k)
                 {
                     sum=(long)nums[i]+nums[j]+nums[l]+nums[k];
                      if(target==sum)
                     {
                      list.add(Arrays.asList(nums[i],nums[j],nums[l],nums[k]));
                      while (l < k && nums[l] == nums[l + 1]) l++;
                        while (l < k && nums[k] == nums[k - 1]) k--;

                        l++;
                        k--;
                     }
                     else if(sum<target)
                     l++;
                     else
                     k--;
                 }
            }
        }
        return list;
    }
}
