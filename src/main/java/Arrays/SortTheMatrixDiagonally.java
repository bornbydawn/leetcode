package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortTheMatrixDiagonally {
   

    public static void main(String[] args) {
        SortTheMatrixDiagonally object = new SortTheMatrixDiagonally();

        int matrix[][] = new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        int result[][] = object.diagonalSort(matrix);
        for(int[] x: result){
            System.out.println(Arrays.toString(x));
        }
       
    }



    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < mat.length; i ++){
            for(int j = 0; j < mat[0].length; j++){
                if(map.containsKey(i - j)){
                    map.get(i - j).add(mat[i][j]);
                }
                else{
                    List<Integer> list = new LinkedList<Integer>();
                    list.add(mat[i][j]);
                    map.put(i-j, list);
                } 
            }
        }

        for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }


        for(int i = 0; i < mat.length; i ++){
            for(int j = 0; j < mat[0].length; j++){
                List<Integer> list = map.get(i-j);
               mat[i][j] = map.get(i-j).get(0);
               list.remove(0);
                
            }
        }

        return mat;
    }

}
