// Problem Number: 2560

// House Robbers IV

class Solution {
   public int minCapability(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0; 
        }

        int min = nums[0], max = nums[0];

        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n); 
        }

        int left = min, right = max; 
        while (left < right) {
            int mid = left + (right - left) / 2; 

            int take = countTake(nums, mid);
            if (take >= k) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }

        return left; 
    }

     
    private int countTake(int[] arr, int mid) {
        int count = 0;
        int index = 0; 
        while (index < arr.length) {
            if (arr[index] <= mid) {
                
                count++; 
                index += 2; 
            } else {
                index++; 
            }
        }
        return count; 
    }
}
