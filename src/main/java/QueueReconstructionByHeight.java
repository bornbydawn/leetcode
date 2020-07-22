import java.util.Arrays;

public class QueueReconstructionByHeight {
    public static void main (String[] args) throws java.lang.Exception
    {
        QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight();

        int[][] input = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        // [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
        int[][] output = queueReconstructionByHeight.reconstructQueue(input);
        System.out.println(Arrays.deepToString(output));
    }

    public class ArrayWrapper{
        int[][] answer;
    }

    public int[][] reconstructQueue(int[][] people) {
        ArrayWrapper answer = new ArrayWrapper();
        permute(people, 0, people.length - 1, answer);
        return answer.answer;
    }

    private void permute(int[][] arr, int l, int r, ArrayWrapper answer)
    {
        if (l == r){
            if(checkIfPermutationValid(arr)){
                answer.answer = Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new);
            }
        }
        else
        {
            for (int i = l; i <= r; i++)
            {
                swap(arr,l,i);
                permute(arr, l+1, r, answer);
                swap(arr,l,i);
            }
        }

    }
    private void swap(int[][] arr, int i, int j){
        int tempi = arr[i][0];
        int tempj = arr[i][1];
        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];
        arr[j][0] = tempi;
        arr[j][1] = tempj;
    }

    private boolean checkIfPermutationValid(int [][] arr){
        if(arr[0][1] != 0){
            return false;
        }
        else{

            for(int i = 0; i < arr.length; i++) {
                if(arr[i][1] > i) return false;
            }
            for(int i = arr.length - 1 ; i > 0; i-- ){
                int greaterThanICount = 0;
                for(int j = 0; j < i; j++){
                    if(arr[j][0] >= arr[i][0]) greaterThanICount++;
                }
                if(greaterThanICount != arr[i][1]) return false;
            }
        }
        return true;
    }
}
