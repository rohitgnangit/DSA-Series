// Q: Print no.of subsequences which sum is equal to 'K'

import java.util.ArrayList;

class Main {
    public static int subsequenceSum(int[] arr, ArrayList<Integer> list, int i, int n, int sum, int k) {
        if (i == n) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }
        // Pick
        list.add(arr[i]);
        sum += arr[i];
        int pick = subsequenceSum(arr, list, i+1, n, sum, k);
        sum -= list.get(list.size()-1);
        list.remove(list.size()-1);
        // Not Pick
        int notPick = subsequenceSum(arr, list, i+1, n, sum, k);
        return pick + notPick;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {1,2,1};
        int n = arr.length;
        int i = 0;
        int sum = 0;
        int k = 2;
        System.out.println(subsequenceSum(arr, list, i, n, sum, k));
    }
}

// OUTPUT :
// 2