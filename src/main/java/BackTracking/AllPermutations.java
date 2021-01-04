package BackTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AllPermutations {

    public static void main(String[] args) {
        AllPermutations allPermutations = new AllPermutations();
        int []arr = new int[]{1,2,3};
        System.out.println(allPermutations.permute(arr));

    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> answer = new LinkedList<>();
        permute(nums, 0, nums.length - 1, answer);
        return answer;
    }

    private void permute(int arr[], int l, int r, List<List<Integer>> answer) {
        if (l == r) {
            List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            answer.add(list);
            return;
        } else {
            for (int i = l; i <= r; i++) {
                swap(arr, l, i);
                permute(arr, l + 1, r, answer);
                swap(arr, l, i);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
