package Arrays;

import java.util.Arrays;
public class MinimumIncrementToMakeArrayUnique {
public static void main(String[] args) {
    int []arr = new int[]{3,2,1,2,1,7};
    MinimumIncrementToMakeArrayUnique object = new MinimumIncrementToMakeArrayUnique();
    System.out.println(object.minIncrementForUnique(arr));
}

    public int minIncrementForUnique(int[] A) {
        if(A.length == 0 || A.length == 1) return 0;
        Arrays.sort(A);
        int answer = 0;
        int oldAnswer = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i] <= A[i-1]){
                oldAnswer = answer;
                answer = answer + 1 + Math.abs(A[i] - A[i - 1]);
                A[i] = A[i] + (answer - oldAnswer);
            }
        }
        return answer;
    }
    
}
