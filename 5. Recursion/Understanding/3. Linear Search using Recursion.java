// Q: Linear Search using Recursion

class Main {
    public static int search(int[] nums, int i, int target) {
        // If element not found then return -1
        if (i == nums.length) return -1;
        // If found return index
        if (nums[i] == target) return i;
        return search(nums, i+1, target);
    }
    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 7, 9, 1, 8};
        int target = 9;
        System.out.println(search(nums, 0, target));
    }
}

// OUTPUT :
// 4