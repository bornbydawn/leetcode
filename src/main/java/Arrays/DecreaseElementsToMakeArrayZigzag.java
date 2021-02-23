package Arrays;

import java.util.Arrays;

public class DecreaseElementsToMakeArrayZigzag {
    public static void main(String[] args) {
        //int[] arr = new int[] { 9, 6, 1, 6, 2 };
        //int[] arr = new int[] { 2,1,2 };
        int[] arr = new int[] { 7,4,8,9,7,7,5 };
        System.out.println(new DecreaseElementsToMakeArrayZigzag().movesToMakeZigzag(arr));
    }

    public int movesToMakeZigzag(int[] nums) {

        int movesFirstLess = 0;
        int movesFirstLessTotal = 0;
        int movesFirstMore = 0;
        int movesFirstMoreTotal = 0;

        int[] numsCopy = Arrays.copyOf(nums, nums.length);

        for (int i = 0; i < nums.length - 1; i++) {
            movesFirstLess = 0;
            if (i % 2 == 0) {
                if (!(nums[i] < nums[i + 1])) {
                    movesFirstLess += nums[i] - nums[i + 1] + 1;
                    nums[i] = nums[i] - movesFirstLess;
                }
            } else {
                if (!(nums[i] > nums[i + 1])) {
                    movesFirstLess += nums[i + 1] - nums[i] + 1;
                    nums[i + 1] = nums[i + 1] - movesFirstLess;
                }
            }
            movesFirstLessTotal += movesFirstLess;
        }

        for (int i = 0; i < numsCopy.length - 1; i++) {
            movesFirstMore = 0;
            if (i % 2 == 0) {

                if (!(numsCopy[i] > numsCopy[i + 1])) {
                    movesFirstMore += numsCopy[i + 1] - numsCopy[i] + 1;
                    numsCopy[i + 1] = numsCopy[i + 1] - movesFirstMore;
                }

            } else {
                if (!(numsCopy[i] < numsCopy[i + 1])) {
                    movesFirstMore += numsCopy[i] - numsCopy[i + 1] + 1;
                    numsCopy[i] = numsCopy[i] - movesFirstMore;
                }
            }
            movesFirstMoreTotal += movesFirstMore;

        }
        return Math.min(movesFirstLessTotal, movesFirstMoreTotal);
    }
}
