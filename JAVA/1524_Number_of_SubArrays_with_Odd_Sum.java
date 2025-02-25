// Problem Number: 1524

// Problem Number of Sub-Array with Odd Sum.

class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007; // since answer can be very long thus moduls 10^9+7 (as directed)
        int odd_count = 0; 
        int even_count = 1;
        int prefix_sum = 0;
        int result = 0;

        for (int i=0; i<arr.length; i++) {
            prefix_sum += arr[i];
            
            if (prefix_sum % 2 == 0) {
                result = (result + odd_count) % MOD;
                even_count++;
            } else {
                result = (result + even_count) % MOD;
                odd_count++;
            }
        }
        
        return result;
        
        
    }
}
