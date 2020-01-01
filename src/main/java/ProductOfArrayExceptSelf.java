//https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        int zeroIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                if(zeroCount == 1){
                    zeroCount++;
                    break;
                }
                zeroCount++;
                zeroIndex = i;
            }
            else{
                product *= nums[i];
            }
        }

        int[] result = new int[nums.length];

        if(zeroCount == 0){
            for(int i = 0; i < result.length; i++){
                result[i] = product/nums[i];
            }
        }
        if(zeroCount == 1){
            result[zeroIndex] = product;
        }

        return result;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        //{1,2,0,3} //{1,2,0,0}
        int[] result = productExceptSelf(arr);

        for (int i = 0; i < result.length ; i++){
            System.out.println(result[i]);
        }

    }
}
