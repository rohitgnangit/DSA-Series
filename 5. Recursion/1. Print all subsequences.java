// Q: Print all subsequences of the array

import java.util.ArrayList;

class Main {
    public static void subSequences(int[] arr, ArrayList<Integer> arl, int index, int n) {
        if (index == n) {
            System.out.println(arl);
            return;
        }
        // Take or pick particular index into subsequence
        arl.add(arr[index]);
        subSequences(arr, arl, index+1, n);
        arl.remove(arl.size() - 1);
        // Not take or not pick condition, this element is not added to subsequence
        subSequences(arr, arl, index+1, n);
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> arl = new ArrayList<>();
        int[] arr = {3,1,2};
        int index = 0;
        int n = arr.length;
        subSequences(arr, arl, index, n);
    }
}

// OUTPUT :
// [3, 1, 2]
// [3, 1]
// [3, 2]
// [3]
// [1, 2]
// [1]
// [2]
// []