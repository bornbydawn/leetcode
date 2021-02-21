package Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(k, new Comparator<Pair<Integer, Integer>>() {

            //max heap so bigger value at top
            //rule for mean heap is return o1 - o2 but for max heap we are returning o2-o1
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return (o2.getKey() + o2.getValue()) - (o1.getKey() + o1.getValue());
            }

        });

        int total = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (k > total) {
                    queue.add(new Pair<>(nums1[i], nums2[j]));
                } else {
                    //replace element at top of max heap (maximum out of k elements in heap) with the new lesser value, 
                    //heapify will be called internally in the queueu to get the now maximum element at the top after replacing
                    if (nums1[i] + nums2[j] < queue.peek().getKey() + queue.peek().getValue()) {
                        queue.poll();
                        queue.add(new Pair<>(nums1[i], nums2[j]));
                    }
                }
                total++;
            }
        }

        List<List<Integer>> answer = new ArrayList<>(k);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>(2);
            Pair<Integer, Integer> pair = queue.poll();
            list.add(pair.getKey());
            list.add(pair.getValue());
            answer.add(list);
        }
        return answer;
    }

    public static void main(String[] args) {
        //int[] nums1 = { 1, 7, 11 };
        int[] nums1 = { 1, 1 ,2 };
        //int[] nums2 = { 2, 4, 6 };
        int[] nums2 = { 1,2, 3 };
        int k = 2;
        List<List<Integer>> answer = new FindKPairsWithSmallestSums().kSmallestPairs(nums1, nums2, k);
        answer.stream().forEach(l -> System.out.println(l));
    }
}
