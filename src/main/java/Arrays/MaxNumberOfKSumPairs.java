package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        MaxNumberOfKSumPairs object = new MaxNumberOfKSumPairs();
        // int arr[] = new int[]{3,1,3,4,3};
        // int k = 6;

        int arr[] = new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int k = 3;


        System.out.println(object.maxOperations(arr, k));
    }
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int answer = 0;

        for(int i = 0; i < nums.length; i++){
            if(countMap.containsKey(k - nums[i])){
                answer++;
                int oldCount = countMap.get(k - nums[i]);
                if(oldCount == 1){
                    countMap.remove(k - nums[i]);
                }
                else{
                    countMap.put(k - nums[i], oldCount - 1);
                }
            }
            else{
                Integer oldValue = countMap.get(nums[i]);
                if(oldValue == null){
                    countMap.put(nums[i], 1);
                }
                else{
                    countMap.put(nums[i], oldValue + 1);
                }
                
            }
        }
        return answer;
    }
}
