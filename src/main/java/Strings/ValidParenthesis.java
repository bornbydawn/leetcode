package Strings;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        String s = "]";
        System.out.println(validParenthesis.isValid(s));
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[')
                    return false;
                else
                    stack.pop();
            } else if (s.charAt(i) == '}') {
                if (stack.isEmpty() || stack.peek() != '{')
                    return false;
                else
                    stack.pop();
            }
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(')
                    return false;
                else
                    stack.pop();
            }

            else if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
        }

        if (!stack.isEmpty())
            return false;
        return true;
    }

}
