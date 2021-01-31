package Arrays;

import java.util.TreeSet;

public class MinimizeDeviationInArray {

    public static void main(String[] args) {
        MinimizeDeviationInArray object = new MinimizeDeviationInArray();
        int[] arr = new int[] { 4, 1, 5, 20, 3 };
        System.out.println(object.minimumDeviation(arr));
    }

    public int minimumDeviation(int[] nums) {

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                set.add(nums[i] * 2);
            } else {
                set.add(nums[i]);
            }
        }
        int diff = Integer.MAX_VALUE;
        while (true) {
            int min = set.first();
            int max = set.last();
            int currDiff = max - min;
            diff = Math.min(currDiff, diff);
            if(max % 2 == 0){
                set.remove(max);
                set.add(max/2);
            }
            else{
                break;
            }
        }
        return diff;
    }
}
