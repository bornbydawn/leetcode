package Stacks;

import java.util.Stack;

public class ValidateStackSequences {

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        //int[] popped = new int[]{4, 5, 3, 2, 1};
        int[] popped = new int[]{4, 3, 5, 1, 2};
        System.out.println(new ValidateStackSequences().validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int push = 0;
        int pop = 0;
        while (true) {
            while (!stack.isEmpty() && pop < popped.length && stack.peek() == popped[pop]) {
                stack.pop();
                pop++;
            }
            if (push < popped.length) {
                stack.push(pushed[push]);
                push++;
            } else {
                break;
            }
        }
        if (stack.isEmpty() && push == pushed.length && pop == popped.length) return true;
        return false;
    }
}
