import java.util.Stack;

public class LongestValidParenthesis {

    public int longestValidParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        char[] string = s.toCharArray();
//        Stack<Character> stack = new Stack<>();
        int length = 0;
        int maxLength = 0;

        for (int i = 0; i < string.length; i++) {
            if (string[i] == '(') {
                stack.push(string[i]);
            } else if (string[i] == ')' && stack.isEmpty()) {
               continue;
            } else if (string[i] == ')') {
                if (stack.peek() != '(') {
                    length = 0;
                    stack.empty();
                } else {
                    length += 2;
                    stack.pop();

                    if(length > maxLength){
                        maxLength = length;
                    }
                }
            }
        }
        return maxLength;
    }

    private boolean isValidSet(char[] arr, int start, int end, Stack<Character> stack) {


        for (int i = start; i <= end; i++) {
            if (arr[i] == '(') {
                stack.push(arr[i]);
            } else if (arr[i] == ')' && stack.isEmpty()) {
                return false;
            } else if (arr[i] == ')') {
                if (stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) return false;

        return true;
    }

    public static void main(String[] args) {
        String str = "()(()";
        LongestValidParenthesis obj = new LongestValidParenthesis();
        System.out.println(obj.longestValidParentheses(str));
    }
}
