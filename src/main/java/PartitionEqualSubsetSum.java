import java.util.Arrays;

//https://leetcode.com/problems/partition-equal-subset-sum/
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        return checkIfSubsetOfSum(nums,sum/2);

    }



    private boolean checkIfSubsetOfSum(int[] arr, int sum) {

        boolean dp[][] = new boolean[arr.length + 1][sum + 1];

        //the result will be always true for sum 0
        for(int i = 0; i <= arr.length; i++) dp[i][0] = true;

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {

                if(arr[i - 1] > j) dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i - 1]];
                }
            }
        }
        return dp[arr.length - 1][sum];
    }

//    public boolean canPartition(int[] nums) {
//
//        int sum = Arrays.stream(nums).sum();
//        if(sum % 2 != 0) return false;
//        int dp[][] = new int[nums.length][sum + 1];
//        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
//        return isSumPossible(0, 0, sum/2, nums, dp);
//
//    }
//
//    private boolean isSumPossible(int i, int sum, int target, int nums[], int dp[][]){
//        if(i >= nums.length) return false;
//        if(sum == target) return true;
//        if (dp[i][sum] != -1) return (dp[i][sum] == 0 ? false : true);
//
//        boolean take =  isSumPossible(i + 1, sum + nums[i], target, nums, dp);
//        boolean dontTake = isSumPossible(i + 1, sum, target, nums, dp);
//        if(take || dontTake){
//            dp[i][sum] = 1;
//        }
//        else {
//            dp[i][sum] = 0;
//        }
//        return (dp[i][sum] == 0 ? false : true);
//    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
        int nums[] = new int[]{1, 5, 11, 5};
        System.out.println(obj.canPartition(nums));
    }

}
