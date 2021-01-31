package Arrays;

import java.util.Arrays;

public class NextPermutation {

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void nextPermutation(int[] nums) {

        if(nums.length == 1) return;

        int firstMaxToMin = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                firstMaxToMin = i;
                break;
            }
        }

        if (firstMaxToMin == -1) {
            Arrays.sort(nums);
            return;
        }

        int x = nums[firstMaxToMin - 1];
        int indexWithMinGreaterElement = firstMaxToMin;

        for (int i = firstMaxToMin + 1; i < nums.length; i++) {
            if (nums[i] > x && nums[i] < nums[indexWithMinGreaterElement]) {
                indexWithMinGreaterElement = i;
            }
        }

        swap(nums, firstMaxToMin - 1, indexWithMinGreaterElement);
        Arrays.sort(nums, firstMaxToMin, nums.length);

    }
}
