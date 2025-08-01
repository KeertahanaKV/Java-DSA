public class QuickSort {

    // Function to perform quick sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Function to partition the array using Lomuto partition scheme
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Choose the last element as pivot
        int i = low - 1;        // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot with the element at i+1
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;  // Return pivot index
    }

    // Utility function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    // Main method to test quick sort
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Original array:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }

/*
Time Complexity:
Best Case:    O(n log n)   // When the pivot divides the array into two nearly equal halves
Average Case: O(n log n)   // On average, the pivot reasonably divides the array
Worst Case:   O(n^2)       // When the pivot is always the smallest or largest element (e.g., sorted array)

Space Complexity:
O(log n)                  // Due to recursion stack in the best/average case
O(n)                      // In worst case (e.g., already sorted), recursion depth can be n

Note: Quick Sort is an in-place sorting algorithm (no extra array used for sorting).
*/

