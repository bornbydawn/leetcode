import java.util.HashMap;
import java.util.Map;

public class FourSomeTwo {

    public static void main(String[] args) {

        int[] A = new int[]{1,2};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1,2};
        int[] D = new int[]{0,2};

        System.out.println(fourSumCount(A,B,C,D));
    }
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        if(A.length == 0) return 0;
        Map<Integer, Integer> ABMap = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                if(ABMap.containsKey(A[i] + B[j])){
                    ABMap.put(A[i] + B[j], ABMap.get(A[i] + B[j]) + 1);
                }
                else{
                    ABMap.put(A[i] + B[j], 1);
                }
            }
        }


        int totalZero = 0;
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                if(ABMap.containsKey(-C[i] - D[j])){
                    totalZero += ABMap.get(-C[i] - D[j]);
                }
            }
        }

        return totalZero;

    }
}
