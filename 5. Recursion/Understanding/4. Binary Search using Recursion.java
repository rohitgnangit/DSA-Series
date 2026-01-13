// Q: Binary Search using Recursion

class Main {
    public static int search(int[] nums, int l, int r, int target) {
        // If element not found then return -1
        if (l > r) return -1;
        // If found return index
        int mid = l+(r-l)/2;
        if (nums[mid] == target) {
            return mid;
        } else if (target > nums[mid]) {
            l = mid + 1;
        } else {
            r = mid -1;
        }
        return search(nums, l, r, target);
    }
    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 9, 15};
        int target = 9;
        int l = 0;
        int r = nums.length - 1;
        System.out.println(search(nums, l, r, target));
    }
}

// OUTPUT :
// 4