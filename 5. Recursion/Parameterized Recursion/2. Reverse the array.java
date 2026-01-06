// Q: Reverse the array using Parameterized Recursion

class Main {
    public static int[] reverse(int[] arr, int l, int r){
        if (l >= r) return arr;
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        return reverse(arr, l+1, r-1);
    }
    public static void main(String[] args) {
       int[] arr = {1,2,3,4,5,6};
       int l = 0;
       int r = arr.length-1;
       arr = reverse(arr, l, r);
       for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
       }
    }
}

// OUTPUT :
// 6
// 5
// 4
// 3
// 2
// 1