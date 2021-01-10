package Strings;

public class StringsEqual {
    public static void main(String[] args) {
        StringsEqual stringsEqual = new StringsEqual();
        String[] word1 = new String[]{"ab", "c"};
        String[] word2 = new String[]{"a", "bc"};
        System.out.println(stringsEqual.arrayStringsAreEqual(word1, word2));
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        for (String string : word1) {
            s1.append(string);
        }

        StringBuilder s2 = new StringBuilder();
        for (String string : word2) {
            s2.append(string);
        }

        if (s1.toString().equals(s2.toString())) {
            return true;
        }
        return false;
    }
}
