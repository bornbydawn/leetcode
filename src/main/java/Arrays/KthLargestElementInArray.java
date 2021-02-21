package Arrays;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static void main(String[] args) {
        //int[] nums = new int[]{3,2,1,5,6,4};
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(new KthLargestElementInArray().findKthLargest(nums, 4));
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> integers = new PriorityQueue<>(k);
        for(int i = 0; i < nums.length; i++){
            if(k > i){
                integers.add(nums[i]);
            }
            else{
                if(nums[i] > integers.peek()){
                    integers.poll();
                    integers.add(nums[i]);
                }
            }
        }

        return integers.poll();
        
    }
}
