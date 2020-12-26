import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int nums[] = new int[]{3,2,3};
        System.out.println(majorityElement.majorityElement(nums));

    }
    public int majorityElement(int[] nums) {

        if(nums.length == 1 || nums.length == 2){
            return nums[0];
        }

        int majority = Integer.MIN_VALUE;
        int majorityValue = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int existingValue = map.get(nums[i]);
                if(existingValue + 1 > majority){
                    majority = existingValue + 1;
                    majorityValue = nums[i];
                }
                map.put(nums[i], existingValue + 1);
            }
            else{
                if(1 > majority){
                    majority = 1;
                    majorityValue = nums[i];
                }
                map.put(nums[i], 1);
            }
        }

        return majorityValue;
    }
}
