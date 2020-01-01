import java.util.*;

public class GenerateParenthesis {

    private static void permute(Set<String> strings, String str, int l, int r) {
        if (l == r) {
            if (isValidSet(str)) {
                strings.add(str);
            }
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(strings, str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    private static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(6);
        System.out.println(list);
    }

    private static List<String> generateParenthesis(int n) {

        char[] array = new char[2 * n];
        Arrays.fill(array, 0, n, '(');
        Arrays.fill(array, n, 2 * n, ')');

        Set<String> strings = new HashSet<>();
        permute(strings, new StringBuilder().append(array).toString(), 0, array.length - 1);
        List<String> list = new ArrayList<>(strings);
        return list;
    }

    private static boolean isValidSet(String s) {
        char[] string = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length; i++) {
            if (string[i] == '(') {
                stack.push(string[i]);
            } else if (string[i] == ')' && stack.isEmpty()) {
                return false;
            } else if (string[i] == ')') {
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

}
