package Stacks;

import java.util.Arrays;
import java.util.Stack;


public class FindTheMostCompetitiveSubsequence {
    public static void main(String[] args) {
        FindTheMostCompetitiveSubsequence findTheMostCompetitiveSubsequence = new FindTheMostCompetitiveSubsequence();
        int nums[] = new int[]{2,4,3,3,5,4,9,6};
        int k = 4;
       int[] answer = findTheMostCompetitiveSubsequence.mostCompetitive(nums, k);
       System.out.println(Arrays.toString(answer));
    }

    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int toRemove = nums.length - k;
        
        for(int i = 0; i < nums.length; i++){

            while(toRemove>0 && !stack.isEmpty() && nums[i] < stack.peek()){
                stack.pop();
                toRemove--;
            }
            stack.push(nums[i]);
        }

        while(toRemove != 0){
            stack.pop();
            toRemove--;
        }
        int []answer = new int[k];

        for(int i = k - 1; i >=0 ; i--){
            answer[i] = stack.pop();
        }
        return answer;
    }

}
