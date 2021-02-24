package Stacks;

import java.util.Stack;

public class ScoreOfParenthesis {
    public static void main(String[] args) {
        //String s = "((()(())()))";
         String s = "(())";
        //String s = "()()(())((()))";
        System.out.println(new ScoreOfParenthesis().scoreOfParentheses(s));
    }

    public int scoreOfParentheses(String S) {

        Stack<String> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c == '(')
                stack.push("(");

            else {
                if (stack.peek().equals("(")){
                    stack.pop();
                    stack.push("1");
                }
                else {
                    int curr = 0;
                    while (!stack.peek().equals("(")) {
                        int x = Integer.parseInt(stack.pop());
                        curr += 2 * x;
                    }
                    stack.pop();
                    stack.push(String.valueOf(curr));
                }
            }
        }

        int answer = 0;
        while (!stack.isEmpty()) {
            answer += Integer.parseInt(stack.pop());
        }

        return answer;
    }

}
