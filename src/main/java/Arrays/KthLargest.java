package Arrays;

import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }

    int k;
    PriorityQueue<Integer> integers;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        integers = new PriorityQueue<>(k);
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
    }
    
    public int add(int val) {
         if(k > integers.size()){
             integers.add(val);
         }
         else{
            if(val > integers.peek()){
                integers.poll();
                integers.add(val);
            } 
         }

         return integers.peek();
    }
}
