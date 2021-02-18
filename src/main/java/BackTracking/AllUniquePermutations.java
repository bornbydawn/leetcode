package BackTracking;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AllUniquePermutations {

    public static void main(String[] args) {
        AllUniquePermutations allUniquePermutations = new AllUniquePermutations();
        int []arr = new int[]{2,2,1,1};
        System.out.println(allUniquePermutations.permuteUnique(arr));

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new LinkedList<>();
        //Arrays.sort(nums);
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
                if(shouldSwap(arr, l, i)){
                    swap(arr, l, i);
                    permute(arr, l + 1, r, answer);
                    swap(arr, l, i);
                }
            }
        }
    }

    private boolean shouldSwap(int[] arr, int loopStart, int current){
        for(int i = loopStart; i < current; i++){
            if(arr[i] == arr[current]){
                return false;
            }
        }
        return true;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
