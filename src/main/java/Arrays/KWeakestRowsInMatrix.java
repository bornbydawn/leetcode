package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.util.Pair;

public class KWeakestRowsInMatrix {
    public static void main(String[] args) {
        // int rows[][] = new int[][]{{1,1,0,0,0},
        // {1,1,1,1,0},
        // {1,0,0,0,0},
        // {1,1,0,0,0},
        // {1,1,1,1,1}};
        // int k = 3;

        int rows[][] = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };

        int k = 2;

        System.out.println(Arrays.toString(new KWeakestRowsInMatrix().kWeakestRows(rows, k)));

    }

    public int[] kWeakestRows(int[][] mat, int k) {
        List<Pair<Integer, Integer>> pairList = new ArrayList<>(mat.length);
        int ones;
        for (int i = 0; i < mat.length; i++) {
            ones = 0;
            for (int j = 0; j < mat[i].length; j++) {
                ones += mat[i][j] == 1 ? 1 : 0;
            }
            pairList.add(new Pair<>(i, ones));
        }

        sortByFirstElement(pairList);

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = pairList.get(i).getKey();
        }

        return answer;

    }

    private void sortByFirstElement(List<Pair<Integer, Integer>> pairList) {
        Collections.sort(pairList, new Comparator<Pair<Integer, Integer>>() {

            @Override
            public int compare(final Pair<Integer, Integer> entry1, final Pair<Integer, Integer> entry2) {

                if (entry1.getValue() != entry2.getValue()) {
                    return entry1.getValue() - entry2.getValue();
                } else {
                    return entry1.getKey() - entry2.getKey();
                }
            }
        });
    }
}
