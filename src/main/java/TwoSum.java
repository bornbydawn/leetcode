import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] solution = new int[2];
        for (int i = 0; i < nums.length ; i++) {
            int remaining = target - nums[i];
            if (map.containsKey(remaining)) {
                if (map.get(remaining) != i) {
                    solution[0] = i;
                    solution[1] = map.get(remaining);
                    break;
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] arr = new int[3];
        arr[0] = 3;
        arr[1] = 2;
        arr[2] = 4;

        int target = 6;

        int[] solution = twoSum(arr, target);
        System.out.println(solution[0] + ", " + solution[1]);
    }
}
