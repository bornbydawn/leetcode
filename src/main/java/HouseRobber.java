//https://leetcode.com/problems/house-robber/
public class HouseRobber {

    public static int rob(int[] nums) {

        int[] store = new int[nums.length];
        for(int i = 0; i< store.length ; i++){
            store[i] = Integer.MIN_VALUE;
        }
        return getMax(nums, 0,store);
    }

    private static int getMax(int[] nums, int i, int[] store){
        if(i >= nums.length) return 0;
            if(i == nums.length - 1)
            return nums[i];

        if(store[i] != Integer.MIN_VALUE) return store[i];
        else return store[i] =  Math.max((nums[i] + getMax(nums, i + 2, store)), getMax(nums, i + 1, store));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        System.out.println(rob(arr));
    }
}
