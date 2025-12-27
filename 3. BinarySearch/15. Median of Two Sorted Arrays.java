// Leetcode-4: Median of Two Sorted Arrays
// Level-Hard

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

// Brute Force
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < nums1.length; i++) {
            arr.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            arr.add(nums2[i]);
        }
        Collections.sort(arr);
        System.out.println(arr);
        if (arr.size()%2 != 0) {
            return arr.get(arr.size()/2);
        }
        System.out.println(arr.size()/2+" "+((arr.size()/2)-1));
        double sum = arr.get(arr.size()/2) + arr.get((arr.size()/2)-1);
        double ans = sum/2;
        return ans;
    }
}
