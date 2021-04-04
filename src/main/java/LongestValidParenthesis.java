import java.util.Stack;

public class LongestValidParenthesis {

    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        int maxLength = 0;
        stack.push(-1);
        int top;
        int newTop;

        for (int i = 0; i < s.length(); i++) {
            top = stack.elementAt(stack.size() - 1);
            if (top >=0 && s.charAt(top) == '(' && s.charAt(i) == ')') {
                stack.pop();
                newTop = stack.elementAt(stack.size() - 1);
                maxLength = Math.max(i - newTop, maxLength);
            } else {
                stack.push(i);
            }
        }
        return maxLength;
    }

    // private boolean isValidSet(String s, int start, int end, Stack<Character>
    // stack) {

    // for (int i = start; i <= end; i++) {
    // if (s.charAt(i) == '(') {
    // stack.push(s.charAt(i));
    // } else if (s.charAt(i) == ')' && stack.isEmpty()) {
    // return false;
    // } else if (s.charAt(i) == ')') {
    // if (stack.peek() != '(') {
    // return false;
    // } else {
    // stack.pop();
    // }
    // }
    // }
    // if (!stack.isEmpty())
    // return false;

    // return true;
    // }

    public static void main(String[] args) {
         //String str = "()(()";
        String str = "()(())";
        LongestValidParenthesis obj = new LongestValidParenthesis();
        System.out.println(obj.longestValidParentheses(str));
    }
}
