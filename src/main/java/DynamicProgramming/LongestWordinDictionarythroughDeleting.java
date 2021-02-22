package DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestWordinDictionarythroughDeleting {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("ale", "abple", "apple", "monkey", "plea");
        System.out.println(new LongestWordinDictionarythroughDeleting().findLongestWord("abpcplea", strings));
    }

    public String findLongestWord(String s, List<String> d) {

        Collections.sort(d, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() > o2.length()) {
                    return 1;
                } else {
                    return o2.compareTo(o1);
                }
            }

        });

        for (int i = d.size() - 1; i >= 0; i--) {
            boolean possible =  isSubSequence(d.get(i), s);
            if (possible) {
                return d.get(i);
            }
        }
        return new String();
    }

    private boolean isSubSequence(String str1, String str2)
    {
        int m = str1.length();
        int n = str2.length();
        int j = 0;
        for (int i = 0; i < n && j < m; i++)
            if (str1.charAt(j) == str2.charAt(i))
                j++;
        return (j == m);
    }
}
