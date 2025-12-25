// Q : You have given an array, your task is to find max length of subarray which has atmost 'k' odd numbers

class Main {
    public static void main(String[] args) {
        int[] arr = {12,1,3,1,1,6,7,1,8,1};
        int n = arr.length;
        int k = 2;
        int temp = 0;
        int ans = 0;
        int l = 0;
        for(int r=0;r<n;r++){
            if(arr[r]%2==1){
                temp++;
            }
            while(temp>k){
                if(arr[l]%2==1){
                    temp--;
                }
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        System.out.println(ans);
    }
}

// OUTPUT:
// Maximum size of subarray consisting two odd no's is 4.