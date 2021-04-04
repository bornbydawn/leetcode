package BackTracking;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PermutationsSequence {

    public static void main(String[] args) {
        PermutationsSequence allPermutations = new PermutationsSequence();
        System.out.println(allPermutations.getPermutation(3,3));
    }

    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i+1;
        }
        List<String> answers = permute(arr, n);
        //Collections.sort(answers);
        return answers.get(k-1);
    }

    private List<String> permute(int[] nums, int n) {
        List<String> answer = new LinkedList<>();
        permute(nums, 0, nums.length - 1, answer, new StringBuilder());
        return answer;
    }

    private void permute(int arr[], int l, int r, List<String> answer, StringBuilder stringBuilder) {
        if (l == r) {
            stringBuilder.setLength(0);
            Arrays.stream(arr).map(i -> Integer.valueOf(i)).forEachOrdered(s -> stringBuilder.append(s));
            answer.add(stringBuilder.toString());
            System.out.println(stringBuilder.toString());
            // if(stringBuilder.toString().equals("265183794")){
            //     System.out.println(answer.size());
            // }
            return;
        } else {
            for (int i = l; i <= r; i++) {
                swap(arr, l, i);
                permute(arr, l + 1, r, answer, stringBuilder);
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
