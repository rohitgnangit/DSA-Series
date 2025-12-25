// Leetcode-2149: Rearrange Array Elements by Sign
// Level-Medium

// Input: nums = [3,1,-2,-5,2,-4]
// Output: [3,-2,1,-5,2,-4]
// Explanation:
// The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
// The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
// Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.

class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        int n = nums.length;
        
        for(int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                positive.add(nums[i]);
            } else {
                negative.add(nums[i]);
            }
        }
        int j = 0;
        for(int i = 0; i < n; i+=2) {
            nums[i] = positive.get(j);
            j++;
        }
        int k = 0;
        for(int i = 1; i < n; i+=2) {
            nums[i] = negative.get(k);
            k++;
        }
        return nums;

         // int posIndex = 0;
        // int negIndex = 0;
        // int[] arr = new int[nums.length];

        // while(negIndex < nums.length && nums[negIndex] > 0){
        //     negIndex++;
        // }

        // for(int i=0;i<nums.length;i++){
        //     if(i%2 == 0){
        //         while(nums[posIndex] < 0) {
        //             posIndex++;
        //         }
        //         arr[i] = nums[posIndex];
        //         posIndex++;
        //     }else {
        //         while(nums[negIndex] > 0) {
        //             negIndex++;
        //         }
        //         arr[i] = nums[negIndex];
        //         negIndex++;

        //     }
        // }
        // return arr;
    }
}