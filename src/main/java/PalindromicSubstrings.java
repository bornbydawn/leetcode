import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class PalindromicSubstrings {

    private static int getPalindromicSubstrings(String s1) {

        char[] arr1 = s1.toCharArray();
        List<Pair<Integer, Integer>> pairs = new LinkedList<>();
        for (int i = 0; i < s1.length(); i++) {
            for (int j = i; j < s1.length(); j++) {
                System.out.println("i: " + i + ", j:" + j);
                if (isPalindrome(arr1, i, j)) {
                    pairs.add(new Pair<>(i, j));
                }
            }
        }

        System.out.println(pairs);
        return pairs.size();

    }

    private static boolean isPalindrome(char[] s1, int i, int j) {
        while (i < j) {
            if (s1[i] != s1[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(getPalindromicSubstrings("abc"));
    }
}
