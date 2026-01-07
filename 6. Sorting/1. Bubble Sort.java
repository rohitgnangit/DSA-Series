// Q: Bubble Sort

// Swapping of adjacent elements on a condition
class Main {
    public static void main(String[] args) {
        int[] arr = {20, 70, 90, 30, 10};
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

// OUTPUT :
// 10 20 30 70 90 
