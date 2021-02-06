package Arrays;

import java.util.Arrays;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        LongestHarmoniousSubsequence object = new LongestHarmoniousSubsequence();
        //int[] arr = new int[]{1,3,2,2,5,2,3,7};
        //int[] arr = new int[]{1,2,3,3,1,-14,13,4};
        //int[] arr = new int[]{1,4,1,3,1,-14,1,-13}; //2
        int[] arr = new int[]{1,2,3,4,6,5,-5,10,-1,-2,5,4,4,-1,7};
        //int[] arr = new int[]{1, 1, 1, 1};
        //int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(object.findLHS(arr));
    }

    public int findLHS(int[] nums) {
        int numZero;
        int numOne;
        int numMinusOne;
        int maxLength = Integer.MIN_VALUE;

        //for(int i = 0; i < nums.length; i++) nums[i] = Math.abs(nums[i]);
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            numZero = numOne = numMinusOne = 0;
            for (int j = 0; j < nums.length; j++) {
                int difference = nums[j] - nums[i];
                if(difference > 1) break;
                else if (difference == -1) numMinusOne++;
                else if (difference == 0) numZero++;
                else if (difference == 1) numOne++;
            }
            if (numOne > 0) {
                maxLength = Math.max(maxLength, Math.max(numMinusOne, numOne) + numZero);
            }
        }

        return Math.max(0, maxLength);
    }


//    public int findLHS(int[] nums) {
//        int numZero;
//        int numOne;
//        int numMinusOne;
//        int maxLength = Integer.MIN_VALUE;
//
//        //Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length; i++) {
//            numZero = numOne = numMinusOne = 0;
//            for (int j = 0; j < nums.length; j++) {
//                int difference = nums[i] - nums[j];
//                if (difference == 0) numZero++;
//                else if (difference == 1) numOne++;
//                else if (difference == -1) numMinusOne++;
//            }
//            if (numOne > 0) {
//                maxLength = Math.max(maxLength, Math.max(numMinusOne, numOne) + numZero);
//            }
//        }
//
//        return Math.max(0, maxLength);
//    }
}
