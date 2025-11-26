public class RotatedBinarySearch {
    // Returns index of target in nums, or -1 if not found
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            // If left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    // target in left sorted half
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right half must be sorted
                if (nums[mid] < target && target <= nums[right]) {
                    // target in right sorted half
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    // Quick test
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 0)); // prints 4
        System.out.println(search(arr, 3)); // prints -1
    }
}
