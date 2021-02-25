package Arrays;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        //int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        //int[] nums = new int[]{1,2,3,4};
        //int[] nums = new int[]{1};
        //int[] nums = new int[]{5,4,3,2,1};
        int[] nums = new int[]{0,1,5,6,4,16,8,17,10,2,3,14,15};
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(nums));
    }

    public int findUnsortedSubarray(int[] nums) {
        int firstShorterIndex = Integer.MIN_VALUE;
        int firstBiggerIndex = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                firstShorterIndex = i;
                break;
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] > nums[i]) {
                firstBiggerIndex = i;
                break;
            }
        }
        if (firstShorterIndex == Integer.MIN_VALUE) return 0;
        int min = nums[firstBiggerIndex];
        int max = nums[firstShorterIndex];
        for (int i = firstShorterIndex; i <= firstBiggerIndex; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int minIndex = 0;
        int maxIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min) {
                minIndex = i;
                break;
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < max) {
                maxIndex = i;
                break;
            }
        }

        return (maxIndex - minIndex) + 1;

    }
}
