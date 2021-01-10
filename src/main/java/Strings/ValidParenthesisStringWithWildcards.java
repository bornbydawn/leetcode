package Strings;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidParenthesisStringWithWildcards {

    public static void main(String[] args) {

        //String s = "(*)";
        //String s = "()";
        //String s = "(***))";
        String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
        ValidParenthesisStringWithWildcards object = new ValidParenthesisStringWithWildcards();
        System.out.println(object.checkValidString(s));
    }

    public boolean checkValidString(String s) {

        Stack<Character> stack = new Stack<>();
        Queue<Character> q
                = new LinkedList<>();
        int openCount = 0;
        int starCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) return false;

                if (openCount > 0) {
                    while (stack.peek() != '(') {
                        q.add(stack.pop());
                    }
                    stack.pop();
                    while (!q.isEmpty()) {
                        stack.push(q.poll());
                    }
                    openCount--;
                    continue;
                } else if (stack.peek() == '(') {
                    stack.pop();
                    openCount--;
                    continue;
                } else if (stack.peek() == '*') {
                    stack.pop();
                    starCount--;
                    continue;
                } else if (stack.peek() == ' ') {
                    while (stack.peek() == ' ') {
                        stack.pop();
                    }
                    if (stack.peek() != '(' && stack.peek() != '*') {
                        return false;
                    } else {
                        if(stack.peek() == '(') openCount--;
                        else{
                            starCount--;
                        }
                        stack.pop();
                        continue;
                    }
                }
            } else {
                if (s.charAt(i) == '(') {
                    openCount++;
                } else if (s.charAt(i) == '*') {
                    starCount++;
                }
                stack.push(s.charAt(i));
            }
        }

        int cRemoved = 0;
        if (stack.isEmpty()) return true;
        else {
            while (!stack.isEmpty()) {
                char c = stack.pop();
                if (c == '*') {
                    if (openCount > 0) {
                        openCount--;
                        cRemoved++;
                    }
                    starCount--;
                    continue;

                } else if (c == '(') {
                    if (cRemoved > 0) {
                        cRemoved--;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
