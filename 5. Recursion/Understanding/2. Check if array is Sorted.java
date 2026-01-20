// Q: Check the array is sorted or not using Recursion

class Main {
    public static boolean isSorted(int[] nums, int i) {
        if (i == nums.length - 1) return true;
        if (nums[i] > nums[i+1]){
            return false;
        }
        return isSorted(nums, i+1);
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int max = 0;
        System.out.println(isSorted(nums,0));
    }
}

// OUTPUT :
// true