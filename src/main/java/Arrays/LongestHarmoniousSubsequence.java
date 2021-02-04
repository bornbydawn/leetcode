package Arrays;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        LongestHarmoniousSubsequence object = new LongestHarmoniousSubsequence();
        int[] arr = new int[]{1,3,2,2,5,2,3,7};
        System.out.println(object.findLHS(arr));
    }
    public int findLHS(int[] nums) {
        int numZero = 0;
        int numOne = 0;
        int maxLength = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            numZero = numOne = 0;
            for(int j = 0; j < nums.length; j++){
                if(Math.abs(nums[i] - nums[j]) == 0) numZero++;
                if(Math.abs(nums[i] - nums[j]) == 1) numOne++;
            }
            if(numOne > 0){
                maxLength = Math.max(maxLength, numOne + numZero);
            }
        }

        return maxLength;
    }
}
