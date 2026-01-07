// Q: Selection Sort

// Swapping of small element with the selected element
class Main {
    public static void main(String[] args) {
        int[] arr = {20, 70, 90, 30, 10};
        int n = arr.length;
        int min = 0;
        
        for(int i=0;i<n-1;i++){
            min = i;
            for(int j=i+1;j<n;j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

// OUTPUT : 
// 10 20 30 70 90