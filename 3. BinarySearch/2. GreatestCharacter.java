// Q : Given an array of character sorted array in ascending order, find the greatest character that is less than the target character in the array, if there is no such a element(target) in array then return 'a'.

class Main {
    public static char bs(char[] nums, char target) {
        int l = 0;
        int r = nums.length-1;
        
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return nums[mid];
            }else if(target<nums[mid]){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        if(r==-1){
            return 'a';
        }
        return nums[r];
    }
    public static void main(String[] args) {
        char[] nums = {'c', 'e', 'g', 'k', 'y'};
        char target = 'd';
        System.out.println(bs(nums, target));
    }
}

// OUTPUT :
// c