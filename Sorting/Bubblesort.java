public class BubbleSort {

    // Function to perform bubble sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if elements are in wrong order
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped in the inner loop, break (array is already sorted)
            if (!swapped) break;
        }
    }

    // Utility function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main function to test the sort
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Original array:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
/*
Time Complexity:
Best Case:    O(n)        // When the array is already sorted. The inner loop does no swaps, so it breaks early.
Average Case: O(n^2)      // Nested loops run for most cases when elements are randomly ordered.
Worst Case:   O(n^2)      // When the array is sorted in reverse order. Every pass does maximum number of comparisons and swaps.

Space Complexity:
O(1)                     // Bubble sort is an in-place sorting algorithm. No extra space is used apart from a few variables.
*/
