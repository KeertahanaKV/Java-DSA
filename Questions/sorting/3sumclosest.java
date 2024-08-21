

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum, prev, j, k, ans, curr;
        ans = 0;
        prev = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate values for i
            }

            j = i + 1;
            k = nums.length - 1;

            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                curr = Math.abs(sum - target);

                // Update closest sum if the current sum is closer to the target
                if (curr < prev) {
                    prev = curr;
                    ans = sum;
                }

                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    // If the sum equals the target, it's the closest possible sum
                    return sum;
                }

            }
        }

        return ans;
    }
}
