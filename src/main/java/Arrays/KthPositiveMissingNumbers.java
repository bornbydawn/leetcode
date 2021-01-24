package Arrays;

import java.util.HashSet;
import java.util.Set;

public class KthPositiveMissingNumbers {

    public static void main(String[] args) {
        KthPositiveMissingNumbers kthPositiveMissingNumbers = new KthPositiveMissingNumbers();
        //int arr[] = new int[]{1, 2, 3, 4};
        int arr[] = new int[]{2,3,4,7,11};
        System.out.println(kthPositiveMissingNumbers.findKthPositive(arr, 5));
    }

    public int findKthPositive(int[] arr, int k) {

        int num = 1;
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hashSet.add(arr[i]);
        }


        int targetValue = 0;
        while (k != 0) {
            if (hashSet.contains(num)) {
                num++;
            } else {
                targetValue = num;
                num++;
                k--;
            }
        }
        return targetValue;
    }

//    public int findKthPositive(int[] arr, int k) {
//
//        int num = 1;
//        Set<Integer> hashSet = new HashSet<>();
//        for (int i = 0; i < arr.length; i++) {
//            hashSet.add(arr[i]);
//        }
//
//
//        int targetValue = 0;
//        while (k != 0) {
//            if (hashSet.contains(num)) {
//                num++;
//            } else {
//                targetValue = num;
//                num++;
//                k--;
//            }
//        }
//        return targetValue;
//    }
}
