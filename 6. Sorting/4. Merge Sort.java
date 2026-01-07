// Q: Merge Sort

import java.util.*;

class Main {
    public static void sort(int[] arr, int low, int high, int mid) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while (left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        // Adding remaining elements
            while (left <= mid) {
                temp.add(arr[left]);
                left++;
            }
        // Adding remaining elements
            while (right <= high) {
                temp.add(arr[right]);
                right++;
            }
            for (int i = low; i <= high; i++) {
                arr[i] = temp.get(i-low);;
            }
    }
    public static void mergeSort(int[] arr, int low, int high) {
        if(low >= high) return;
        int mid = (low+high)/2;
        // First Half
        mergeSort(arr, low, mid);
        // Second Half
        mergeSort(arr, mid+1, high);
        sort(arr, low, high, mid);
    }
    public static void main(String[] args) {
        int[] arr = {2,9,1,3,1,8,5};
        int low = 0;
        int high = arr.length-1;
        mergeSort(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }
}

// OUTPUT :
// [1, 1, 2, 3, 5, 8, 9]