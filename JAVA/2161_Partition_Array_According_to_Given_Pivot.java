// Problem Number: 2161

// Partition Array according to given Pivot.

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int ans[]= new int[nums.length];
        int i=0;

        for(int num:nums){
            if(num<pivot){
                ans[i++]=num;
            }
        }

        for(int num:nums){
            if(num==pivot){
                ans[i++]=num;
            }
        }

        for(int num:nums){
            if(num>pivot){
                ans[i++]=num;
            }
        }
        return ans;
    }

}
