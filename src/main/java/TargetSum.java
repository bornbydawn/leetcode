import java.util.Arrays;

//https://leetcode.com/problems/target-sum/#
public class TargetSum {


    public int findTargetSumWays(int[] nums, int S) {

        int maxCurrentSum = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2*maxCurrentSum + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return permute(nums, 0, S, 0, dp, maxCurrentSum);

    }

    private int permute(int[] nums, int i, int S, int currentSum, int[][]dp, int maxCurrentSum) {

        if (i == nums.length) {
            if (currentSum == S) {
                return 1;
            }
            return 0;
        }

        if(dp[i][currentSum + maxCurrentSum] != -1) return dp[i][currentSum + maxCurrentSum];

        return dp[i][currentSum + maxCurrentSum] = permute(nums, i + 1, S, currentSum + nums[i], dp, maxCurrentSum) + permute(nums, i + 1, S, currentSum - nums[i], dp, maxCurrentSum);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0};
        int S = 1;
        TargetSum targetSum = new TargetSum();
        //System.out.println(targetSum.findTargetSumWays(nums, S));
        System.out.println(targetSum.findTargetSumWays(nums, S));
    }


//    static int a = 0;
//
//    public int findTargetSumWays(int[] nums, int S) {
//        a = 0;
//        permute(nums, 0, S);
//        return a;
//    }
//
//    private void permute(int[] nums, int i, int S) {
//
//        if(i == nums.length){
//            if (calculateSum(nums, S)) {
//                a++;
//            }
//        }
//        else{
//            nums[i] = nums[i] * -1;
//
//            permute(nums, i + 1, S);
//
//            nums[i] = nums[i] * -1;
//
//            permute(nums, i + 1, S);
//        }
//    }
//
//    private boolean calculateSum(int[] nums, int S) {
//        int answer = 0;
//        for (int i = 0; i < nums.length; i++) {
//            answer += nums[i];
//        }
//        if (answer == S) return true;
//        return false;
//    }
//
//    public static void main(String[] args) {
//        int nums[] = new int[]{1, 1, 1, 1, 1};
//        int S = 3;
//        TargetSum targetSum = new TargetSum();
//        //System.out.println(targetSum.findTargetSumWays(nums, S));
//        targetSum.findTargetSumWays(nums, S);
//        System.out.println(a);
//    }

}
