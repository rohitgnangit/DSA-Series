// Q: Insertion Sort

class Main {
    public static void main(String[] args) {
        int[] arr = {40, 30, 20, 50, 10};
        int n = arr.length;
        int j = 0;
        
        for(int i=0;i<n;i++){
            int temp = arr[i];
            j = i-1;
            
            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

// OUTPUT : 
// 10 20 30 40 50 