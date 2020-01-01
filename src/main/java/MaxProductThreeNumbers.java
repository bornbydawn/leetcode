public class MaxProductThreeNumbers {

    public int maximumProduct(int[] nums) {
        int maxPos = 0;
        int maxPos2 = 0;
        int maxPos3 = 0;

        int maxNeg = 0;
        int maxNeg2 = 0;
        int maxNeg3 = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) continue;
            if (nums[i] > 0) {
                if (nums[i] > maxPos) {
                    maxPos3 = maxPos2;
                    maxPos2 = maxPos;
                    maxPos = nums[i];
                } else if (nums[i] > maxPos2) {
                    maxPos3 = maxPos2;
                    maxPos2 = nums[i];
                } else if (nums[i] > maxPos3) {
                    maxPos3 = nums[i];
                }
            } else {

                if (nums[i] < maxNeg) {
                    maxNeg3 = maxNeg2;
                    maxNeg2 = maxNeg;
                    maxNeg = nums[i];
                } else if (nums[i] < maxNeg2) {
                    maxNeg3 = maxNeg2;
                    maxNeg2 = nums[i];
                }
                else if(nums[i] < maxNeg3){
                    maxNeg3 = nums[i];
                }
            }
        }

        int positiveProduct = maxPos * maxPos2 * maxPos3;
        int negativeProduct = maxPos * maxNeg * maxNeg2;

        int allNegative = maxNeg * maxNeg2 * maxNeg3;

        if(positiveProduct == 0 && negativeProduct == 0){
            return allNegative;
        }

        return positiveProduct > negativeProduct ? positiveProduct : negativeProduct;
    }
}
