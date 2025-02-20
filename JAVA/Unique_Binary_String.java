// Leetcode Problem No: 1980

// Find Unique Binary String

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            // Flip the i-th bit of the i-th string
            char flippedBit;
            if(nums[i].charAt(i)=='0'){
                flippedBit='1';
            }
            else{
                flippedBit='0';
            }
            
            result.append(flippedBit);
        }
        
        return result.toString();
        
    }
}
