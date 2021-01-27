package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javafx.util.Pair;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals object = new MergeIntervals();
        // int [][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        //int[][] intervals = new int[][] { { 1, 4 }, { 0, 4 }, { 8, 10 }, { 15, 18 } };
        //int[][] intervals = new int[][] { { 1, 4 }, { 1, 5 }};
        //int[][] intervals = new int[][] { { 1, 4 }, { 2, 3 }};
        int[][] intervals = new int[][] {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] answer = object.merge(intervals);
        for (int[] x : answer)
            System.out.println(Arrays.toString(x));
    }

    public int[][] merge(int[][] intervals) {
        sortByFirstElement(intervals);
        List<Pair<Integer, Integer>> answerList = new ArrayList<>();


        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i < intervals.length - 1 && end >= intervals[i + 1][0]) {
                end = Math.max(intervals[i + 1][1],  end);
                i++;
            }
            answerList.add(new Pair<Integer, Integer>(start, end));
        }
        int[][] answer = new int[answerList.size()][2];
        int index = 0;
        for (Pair<Integer, Integer> pair : answerList) {
            answer[index][0] = pair.getKey();
            answer[index][1] = pair.getValue();
            index++;
        }
        return answer;
    }

    private void sortByFirstElement(int arr[][]) {
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(final int[] entry1, final int[] entry2) {

                if (entry1[0] > entry2[0])
                    return 1;
                else if (entry1[0] < entry2[0])
                    return -1;
                else
                    return entry1[1] - entry2[1];
            }
        });
    }
}
