package Arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        //both Collections.reverseOrder() and Comparator.reverseOrder() work.
        //internally Collections.reverseOrder() returns  Comparator.reverseOrder() only
        //PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        int total = 0;
        for(int i = 0; i < matrix.length ; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(k > total){
                    queue.add(matrix[i][j]);
                }
                else{
                    if(matrix[i][j] < queue.peek()){
                        queue.poll();
                        queue.add(matrix[i][j]);
                    }
                }
                total++;
            }
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        System.out.println(new KthSmallestElementInASortedMatrix().kthSmallest(matrix, k));
    }
}
