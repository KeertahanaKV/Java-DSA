public class InsertionSort {

    // Function to perform insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Start from the second element (index 1)
        for (int i = 1; i < n; i++) {
            int key = arr[i];       // Current element to be inserted
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key
            // one position ahead to make space for key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];  // Shift right
                j--;
            }

            arr[j + 1] = key;  // Insert key at the correct position
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
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Original array:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
/*
Time Complexity:
Best Case:    O(n)        // When the array is already sorted. Only one comparison per element.
Average Case: O(n^2)      // Elements are randomly ordered. Comparisons and shifts are done.
Worst Case:   O(n^2)      // When array is sorted in reverse. Every element needs to be compared and shifted.

Space Complexity:
O(1)                     // In-place sort. No extra space used apart from a few variables.
*/
