/*
In general, the problem is NP-hard. However, if the numbers are small integers, there is a (reasonably) efficient solution based on dynamic programming.This works as follows:
Let there be n numbers x_1,...,x_n that sum up to W. The algorithm maintains a (k+1)-dimensional array A whose first k dimensions range from 0 to W and the last dimension from 0 to n. The entries in the array are from {0,1} with the meaning that A[i_1,...,i_k,j]=1, iff the first j numbers can be partitioned into sets that sum up to i_1,..., i_k.
Clearly, A[i_1,...,i_k,0] = 0, iff at least one i_j<>0. and A[0,...,0,0] = 1. Then one can fill the array recursively along the last dimension in the following way:
A[i_1,...,i_k,j] = 1, if A[i_1 - x_j,...,i_k,j-1] = 1 or A[i_1,i_2-x_j,...,i_k,j-1]=1, ...or
A[i_1,..,i_k-x_j,j-1]=1 (where one has to make sure that no negative index occurs).
Once the array is filled, one can look for the best solution in A[i_1,...,i_k,n].
The running time of the algorithm is something like O(nk W^k), so it'll work, if W and k are not too big...Hope that helps!



https://www.youtube.com/watch?v=qpgqhp_9d1s
 */



import java.util.Arrays;
import java.util.OptionalInt;

public class PartitionKEqualSubsetSum {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        if (nums.length < 1) return false;
        if (nums.length / k < 1) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        OptionalInt max = Arrays.stream(nums).max();
        int targetSum = sum / k;

        if (max.isPresent()) {
            if (max.getAsInt() > targetSum) return false;
        }
        boolean used[] = new boolean[nums.length];

        return canPartition(0, nums, used, k, 0, targetSum);

    }

    private boolean canPartition(int iterationStart, int nums[], boolean used[], int k, int progressBucketSum, int targetBucketSum){
        if(k == 1) return true;

        if(progressBucketSum > targetBucketSum) return false;

        if(progressBucketSum == targetBucketSum){
            return canPartition(0, nums, used, k - 1, 0, targetBucketSum);
        }

        for(int i = iterationStart; i < nums.length; i++){
            if(!used[i]){
                used[i] = true;
                if(canPartition(i+1, nums, used, k, progressBucketSum + nums[i], targetBucketSum)){
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionKEqualSubsetSum partitionKEqualSubsetSum = new PartitionKEqualSubsetSum();
//        int nums[] = new int[]{2,2,2,2,3,4,5};
//        System.out.println(partitionKEqualSubsetSum.canPartitionKSubsets(nums, 4));


        int nums[] = new int[]{10,10,10,7,7,7,7,7,7,6,6,6};
        System.out.println(partitionKEqualSubsetSum.canPartitionKSubsets(nums, 3));
    }

}

