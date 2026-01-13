// Q: Largest element in Array using Recursion


class Main {
    public static int maxElem(int[] nums, int i, int max) {
        if (i == nums.length) return max;
        if (max < nums[i]) {
            max = nums[i];
        }
        return maxElem(nums, i+1, max);
    }
    public static void main(String[] args) {
        int[] nums = {4,2,7,1,9,5};
        int max = Integer.MIN_VALUE;
        System.out.println(maxElem(nums,0, max));
    }
}

// OUTPUT :
// 9