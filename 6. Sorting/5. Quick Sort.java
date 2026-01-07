// Q: Quick Sort

import java.util.*;

class Main {
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int l = low;
        int r = high;
        while (l < r) {
            while (arr[l] <= pivot && l <= high) {
                l++;
            }
            while (arr[r] > pivot && r >= low) {
                r--;
            }
            if (l < r) {
                // Swapping
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        // Swapping Pivot with right
        int temp = arr[low];
        arr[low] = arr[r];
        arr[r] = temp;
        return r;
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            // First Half
            quickSort(arr, low, pIndex-1);
            // Second Half
            quickSort(arr, pIndex+1, high);
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,6,2,5,7,9,1,3};
        int low = 0;
        int high = arr.length-1;
        quickSort(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }
}

// OUTPUT :
// [1, 2, 3, 4, 5, 6, 7, 9]