package Arrays;

import java.util.Arrays;

public class CreateSortedArrayThroughInstructions {
    public static void main(String[] args) {

        CreateSortedArrayThroughInstructions object = new CreateSortedArrayThroughInstructions();
        //int[] ins = new int[]{1,3,3,3,2,4,2,1,2};
        int[] ins = new int[]{1,2,3,3, 4,3};
        //int[] ins = new int[]{1,2,3,6,5,4};
        //int[] ins = new int[]{1,5,6,2};
        System.out.println(object.createSortedArray(ins));
    }


    public int createSortedArray(int[] instructions) {
        if (instructions.length == 1) return 0;
        int arr[] = new int[instructions.length];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = instructions[0];
        int cost = 0;
        for(int i = 1; i < instructions.length; i++){
            arr[i] = instructions[i];
            cost += sort(arr, i);
        }
        return cost;

    }

    private int sort(int arr[], int size) {
        int i = size;

        int key = arr[i];
        int j = i - 1;
        int firstSame = Integer.MIN_VALUE;
        boolean marked = false;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
        while (j >= 0 && arr[j] >= key) {
            if(arr[j] == key && !marked){
                firstSame = j;
                marked = true;
            }
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
        int backCost = firstSame == Integer.MIN_VALUE ? size - (j + 1) : Math.min(size - (j + 1), size - firstSame -1);
        int frontCost = j + 1;
        return Math.min(backCost, frontCost);
    }
}
