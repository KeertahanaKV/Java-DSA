public class MergeSort {

    // Function to perform merge sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Recursively sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Function to merge two sorted subarrays
    public static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temp arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        // Merge the temp arrays back into arr[left..right]
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements of leftArr[] (if any)
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements of rightArr[] (if any)
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    // Utility function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method to test the sort
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original array:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
/*
Time Complexity:
Best Case:    O(n log n)     // Always divides array into halves, and merges in linear time
Average Case: O(n log n)
Worst Case:   O(n log n)

Space Complexity:
O(n)                        // Requires extra space for temporary arrays (not in-place)
*/


