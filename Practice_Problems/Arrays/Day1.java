// Link: https://leetcode.com/problems/find-closest-number-to-zero/

class Solution {
    public int findClosestNumber(int[] nums) {
        
        int ans = Integer.MIN_VALUE,distance = Integer.MAX_VALUE;
        
        for(int i:nums){
            
            if(Math.abs(i)<distance){
                
                distance = Math.abs(i);
                ans = i;
            }
            
            else if(Math.abs(i)==distance) ans = Math.max(ans,i);
        }
        
        return ans;
    }
}
