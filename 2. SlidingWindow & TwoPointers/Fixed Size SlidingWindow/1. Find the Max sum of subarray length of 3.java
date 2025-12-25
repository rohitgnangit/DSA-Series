// Q: : Find the Max sum of subarray length of 3

class Main {
    public static void main(String[] args) {
        int arr[] = {2,3,4,5,6};
        int n = arr.length;
        int l =0;
        int sl = 3;
        int temp = 0;
        int ans = 0;
        for(int r=0;r<n;r++){
            temp+=arr[r];
            if(r-l == sl){
                temp-=arr[l];
                l++;
            }
            if(r-l+1 == sl){
                ans = Math.max(ans, temp);
            }
        }
        System.out.println(ans);
    }
}