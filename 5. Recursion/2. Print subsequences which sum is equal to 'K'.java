// Q: Print subsequences which sum is equal to 'K'

import java.util.ArrayList;

class Main {
    public static void subsequenceSum(int[] arr, ArrayList<Integer> list, int i, int n, int sum, int k) {
        if (i == n) {
            if (sum == k) {
                System.out.println(list);
            }
            return;
        }
        // Pick
        list.add(arr[i]);
        sum += arr[i];
        subsequenceSum(arr, list, i+1, n, sum, k);
        sum -= list.get(list.size()-1);
        list.remove(list.size()-1);
        // Not Pick
        subsequenceSum(arr, list, i+1, n, sum, k);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {1,2,1};
        int n = arr.length;
        int i = 0;
        int sum = 0;
        int k = 2;
        subsequenceSum(arr, list, i, n, sum, k);
    }
}

// OUTPUT :
// [1, 1]
// [2]
