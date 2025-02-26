// Problem Number: 1749

// Maximum Absolute Sum of Any SubArray.

class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        int maxSum = 0;
        int minSum = 0;
        int currMax = 0;
        int currMin = 0;

        for (int n : nums) {
            currMax = max(0, currMax + n); 
            currMin = min(0, currMin + n); 
            
            maxSum = max(maxSum, currMax);
            minSum = min(minSum, currMin);
        }

        return max(maxSum, -minSum);

    }
};
