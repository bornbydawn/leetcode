import java.util.HashMap;
import java.util.Map;

public class SubarraySumKNumbers {

    //    public int subarraySum(int[] nums, int k) {
//
//        int n = nums.length;
//        if(n == 0) return 0;
//
//        int count = 0;
//        int sum;
//
//        for(int i = 0; i < n; i++){
//            sum = 0;
//            for(int j = i; j < n; j++){
//                sum = sum + nums[j];
//                if(sum == k) count++;
//            }
//        }
//        return count;
//    }
    public int subarraySum(int[] nums, int k) {

        //preSum map stores all the sums encountered till now
        //keep putting all sums in the map
        //at any point if you find sum - k already in the map
        //then it means you have a valid sum of k

        //more deeply
        //map(i, count) tells that in how many ways you can remove (sum - k)
        //from the sum so that you get k
        //i.e. sum - (sum - k) = k
        //practice with the set
        //7,0,-4,4,-1,1,3

        int n = nums.length;
        if (n == 0) return 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        //0 sum is possible without any number so put 1 count for that
        preSum.put(0, 1);
        int count = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            count += preSum.getOrDefault(sum - k, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumKNumbers subarraySumKNumbers = new SubarraySumKNumbers();
//        int nums[] = new int[]{28, 54, 7, -70, 22, 65, -6};
//        System.out.println(subarraySumKNumbers.subarraySum(nums, 100));
        int nums[] = new int[]{2,5,-2,0,4};
        System.out.println(subarraySumKNumbers.subarraySum(nums, 0));
    }


}