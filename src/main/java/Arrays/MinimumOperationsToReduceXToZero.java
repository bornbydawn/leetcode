package Arrays;

import java.util.Arrays;

public class MinimumOperationsToReduceXToZero {

    public static void main(String[] args) {

        MinimumOperationsToReduceXToZero object = new MinimumOperationsToReduceXToZero();
        int nums[] = new int[]{6016,5483,541,4325,8149,3515,7865,2209,9623,9763,4052,6540,2123,2074,765,7520,4941,5290,5868,6150,6006,6077,2856,7826,9119};
        int x = 31841;

        // int nums[] = new int[]{1,1};
        // int x = 3;

        // int nums[] = new int[]{3,2,20,1,1,3};
        // int x = 10;

        // int nums[] = new int[]{1,1,4,2,3};
        // int x = 5;

        // int nums[] = new int[]{5,2,3,1,1};
        // int x = 5;

        // int nums[] = new int[]{1,1,3,2,5};
        // int x = 5;



        System.out.println(object.minOperations(nums, x));
    }
    class BooleanWrapper{
        boolean possible = false;
    }


    class NumWrapper{
        int maxCount = -1;
    }


    // public int minOperations(int[] nums, int x) {
    //     BooleanWrapper possible = new BooleanWrapper();
    //     int asnwer = minOperations(nums, 0, nums.length - 1, x, possible);
    //     if(!possible.possible || asnwer > nums.length) return -1;
    //     return asnwer;
    // }

    private int minOperations(int[] nums, int left, int right, int x, BooleanWrapper possible){

        if(x < 0 || left < 0 || left > nums.length - 1|| right < 0 || right > nums.length - 1) {
            return nums.length;
        }
        if(x == 0){
            possible.possible = true;
            return 0;
        }
        return 1 + Math.min(minOperations(nums, left + 1, right, x - nums[left], possible)
                , minOperations(nums, left, right - 1, x - nums[right], possible));
    }

    public int minOperations(int[] nums, int x) {
        NumWrapper numWrapper = new NumWrapper();
        int sumOfArray =  Arrays.stream(nums).sum();
        printSubArrays(nums, 0, 0, x, sumOfArray, numWrapper);
        return numWrapper.maxCount;
    }

    void printSubArrays(int []arr, int start, int end, int x, int total, NumWrapper numWrapper) 
    {      
        // Stop if we have reached the end of the array      
        if (end == arr.length)  
            return; 
          
        // Increment the end point and start from 0  
        else if (start > end)  
            printSubArrays(arr, 0, end + 1, x, total, numWrapper); 
              
        // Print the subarray and increment the starting point  
        else
        { 
            int sum = 0;
            //System.out.println("start: " + start + ", end: " + end);
            boolean firstEnter = false;
            sum += arr[start];
            for (int i = start; i < end; i++){
                if(!firstEnter){
                    firstEnter = true;
                    continue;
                }
                sum += arr[i];
            } 
              if(total - x == sum){
                  int endStartDiff = end-start;
                 
                  //if(!(start == 0 || start == arr.length - 1)){
                    if(numWrapper.maxCount == -1){
                        numWrapper.maxCount =  arr.length - endStartDiff;
                      }
                      else{
                        numWrapper.maxCount = Math.min(numWrapper.maxCount, arr.length - endStartDiff);
                      }
                 // }
              }
            if(x == sum){
                int endStartDiff = end-start + 1;
                //if(start == 0 || start == arr.length - 1){
                    if(numWrapper.maxCount == -1){
                        numWrapper.maxCount = endStartDiff;
                      }
                      else{
                        numWrapper.maxCount = Math.min(numWrapper.maxCount, endStartDiff);
                      }
                 // }
              }
            printSubArrays(arr, start + 1, end, x, total, numWrapper); 
        } 
          
        return; 
    }
}
