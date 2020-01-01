//https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int maxSoFar = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(max >= 0 && nums[i] == 0){
                continue;
            }
            maxSoFar = nums[i];
            if(maxSoFar > max){
                max = maxSoFar;
            }
            for(int j = i + 1; j < nums.length; j++){
                if(max >= 0 && nums[j] == 0){
                    break;
                }
                maxSoFar = maxSoFar * nums[j];
                if(maxSoFar > max){
                    max = maxSoFar;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,-3,4,-3,0,4};
        System.out.println(maxProduct(arr));
    }
}
