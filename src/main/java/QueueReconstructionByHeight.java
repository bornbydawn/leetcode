import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionByHeight {
    public static void main(String[] args) throws java.lang.Exception {
        QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight();

        int[][] input = {{40,11},{81,12},{32,60},{36,39},{76,19},{11,37},{67,13},{45,39},{99,0},{35,20},{15,3},{62,13},{90,2},{86,0},{26,13},{68,32},{91,4},{23,24},{73,14},{86,13},{62,6},{36,13},{67,9},{39,57},{15,45},{37,26},{12,88},{30,18},{39,60},{77,2},{24,38},{72,7},{96,1},{29,47},{92,1},{67,28},{54,44},{46,35},{3,85},{27,9},{82,14},{29,17},{80,11},{84,10},{5,59},{82,6},{62,25},{64,29},{88,8},{11,20},{83,0},{94,4},{43,42},{73,9},{57,32},{76,24},{14,67},{86,2},{13,47},{93,1},{95,2},{87,8},{8,78},{58,16},{26,75},{26,15},{24,56},{69,9},{42,22},{70,17},{34,48},{26,39},{22,28},{21,8},{51,44},{35,4},{25,48},{78,18},{29,30},{13,63},{68,8},{21,38},{56,20},{84,14},{56,27},{60,40},{98,0},{63,7},{27,46},{70,13},{29,23},{49,6},{5,64},{67,11},{2,31},{59,8},{93,0},{50,39},{84,6},{19,39}};
        //int[][] input = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        // [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
        int[][] output = queueReconstructionByHeight.reconstructQueue(input);
        System.out.println(Arrays.deepToString(output));
    }

    public class ArrayWrapper {
        int[][] answer;
    }

    public int[][] reconstructQueue(int[][] people) {
        ArrayWrapper answer = new ArrayWrapper();
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] > o2[1]){
                    return 1;
                }
                return -1;
            }
        };

        Arrays.sort(people, comparator);
        System.out.println(Arrays.deepToString(people));
        //permute(people, 0, people.length - 1, answer);
        return answer.answer;
    }

    private void permute(int[][] arr, int l, int r, ArrayWrapper answer) {
        if (l == r && checkIfPermutationValid(arr)) {
            answer.answer = Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new);
        } else {
            for (int i = l; i <= r; i++) {
                swap(arr, l, i);
                permute(arr, l + 1, r, answer);
                swap(arr, l, i);
            }
        }
    }

    private void swap(int[][] arr, int i, int j) {
        int tempX = arr[i][0];
        int tempY = arr[i][1];
        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];
        arr[j][0] = tempX;
        arr[j][1] = tempY;
    }

    private boolean checkIfPermutationValid(int[][] arr) {
        if (arr[0][1] != 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] > i) return false;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int greaterThanICount = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j][0] >= arr[i][0]) greaterThanICount++;
            }
            if (greaterThanICount != arr[i][1]) return false;
        }
        return true;
    }
}
