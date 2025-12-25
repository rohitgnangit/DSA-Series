// Leetcode-1876: Substrings of Size Three with Distinct Characters
// Level-Easy

// Input: s = "xyzzaz"
// Output: 1
// Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
// The only good substring of length 3 is "xyz".

class Solution {
    public int countGoodSubstrings(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = s.length();
        int  k = 3;
        int l = 0;
        int ans = 0;
        for(int r=0;r<n;r++){
            char ch = s.charAt(r);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
            if(r-l == k){
                char tch = s.charAt(l);
                hm.put(tch, hm.get(tch)-1);
                if(hm.get(tch)==0){
                    hm.remove(tch);
                }
                l++;
            }
            if(hm.size()==k){
                ans+=1;    
            }
       }
       return ans;
    }
}