import java.util.Arrays;

public class DivideArrayintoEqualPairs {

    public boolean divideArray(final int[] nums) {
    
        final int[] count = new int[501];

        for (final int num : nums)
        ++count[num];

        return Arrays.stream(count).allMatch(c -> c % 2 == 0);
        
    }
    public static void main(String[] args) {
        Solution d=new Solution();
        int[] nums = {3, 2, 3, 2, 2, 2};  
        boolean result = d.divideArray(nums);
        System.out.println("Can divide array into equal pairs? " + result);
    }
}
