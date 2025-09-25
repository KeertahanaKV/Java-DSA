public class QuickSortFirstPivot {

    // Function to perform partition
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];  // take first element as pivot
        int i = low + 1;       // start from next element
        int j = high;

        while (true) {
            // move i forward until we find element > pivot
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            // move j backward until we find element < pivot
            while (i <= j && arr[j] >= pivot) {
                j--;
            }
            // if i crosses j, stop
            if (i > j) {
                break;
            }
            // swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // place pivot at the correct position (swap with arr[j])
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;  // return pivot index
    }

    // QuickSort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            // sort left part
            quickSort(arr, low, pivotIndex - 1);
            // sort right part
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Main function
    public static void main(String[] args) {
        int[] arr = {8, 3, 6, 1, 5};
        int n = arr.length;

        System.out.println("Before Sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        quickSort(arr, 0, n - 1);

        System.out.println("\nAfter Sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
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

