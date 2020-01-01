//https://leetcode.com/problems/house-robber-ii/
public class HouseRobberCircular {

    public static int rob(int[] nums) {

        int[] storeFirstIncluded = new int[nums.length];
        for (int i = 0; i < storeFirstIncluded.length; i++) {
            storeFirstIncluded[i] = Integer.MIN_VALUE;
        }


        int[] store = new int[nums.length];
        for (int i = 0; i < store.length; i++) {
            store[i] = Integer.MIN_VALUE;
        }
        return getMax(nums, 0, storeFirstIncluded, store, false);


    }

    private static int getMax(int[] nums, int i, int[] storeFirstIncluded, int[] store, boolean firstIncluded) {
        if (i >= nums.length) return 0;
        if (i == nums.length - 1) {
            if (firstIncluded) {
                return 0;
            } else {
                return nums[i];
            }
        }

        if(firstIncluded){
            if(storeFirstIncluded[i] != Integer.MIN_VALUE){
                return storeFirstIncluded[i];
            }
        }
        else{
            if(store[i] != Integer.MIN_VALUE){
                return store[i];
            }
        }

        if (i == 0) {
            return Math.max(storeFirstIncluded[i] = (nums[i] + getMax(nums, i + 2, storeFirstIncluded, store, true)),store[i] = getMax(nums, i + 1, storeFirstIncluded, store, false));
        }

        if(firstIncluded){
            return storeFirstIncluded[i] = Math.max((nums[i] + getMax(nums, i + 2,storeFirstIncluded, store, firstIncluded)), getMax(nums, i + 1,storeFirstIncluded,store, firstIncluded));

        }
        else{
            return store[i] = Math.max((nums[i] + getMax(nums, i + 2,storeFirstIncluded, store, firstIncluded)), getMax(nums, i + 1,storeFirstIncluded,store, firstIncluded));
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 1, 3, 100};
        System.out.println(rob(arr));
    }
}
