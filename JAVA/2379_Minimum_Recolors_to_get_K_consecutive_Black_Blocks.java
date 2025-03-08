// Problem Number: 2379

// Minimum Recolors to get K consecutive black blocks.

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int blackCount = 0, ans = Integer.MAX_VALUE;
    
        for (int i = 0; i < blocks.length(); i++) {
            if (i - k >= 0 && blocks.charAt(i - k) == 'B') blackCount--;
            if (blocks.charAt(i) == 'B') blackCount++;
            ans = Math.min(ans, k - blackCount);
        }
        
        return ans;
    }
}
