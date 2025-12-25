// Q: How many members can get into a bus based on their weights, bus can bear max weigth 10kg


class Main {
    public static void main(String[] args) {
        int[] arr = {1,5,7,2,9};
        int k = 10;
        int temp = 0;
        int ans = 0;
        int l=0;
        for(int r =0;r<arr.length;r++){
            temp+=arr[r];
            while(temp>k){
                temp-=arr[l];
                l++;
            }
                ans = Math.max(ans, r-l+1);
        }
        System.out.println(ans);
    }
}