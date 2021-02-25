package BackTracking;

import java.util.LinkedList;
import java.util.List;

public class LetterCaseAllPermutations {

    public static void main(String[] args) {
        LetterCaseAllPermutations allPermutations = new LetterCaseAllPermutations();
        String s = "a1b2";

        List<String> stringList = allPermutations.letterCasePermutation(s);
        for (String s1 : stringList) {
            System.out.println(s1);
        }

    }

    public List<String> letterCasePermutation(String S) {
        List<String> answer = new LinkedList<>();
        permute(S, 0, answer);
        return answer;
    }

    private void permute(String word, int start, List<String> answer) {
        answer.add(word);

        for (int i = start; i < word.length(); i++) {
            char[] wordArray = word.toCharArray();
            if (Character.isLetter(wordArray[i])) {
                wordArray[i] = Character.isUpperCase(wordArray[i]) ? Character.toLowerCase(wordArray[i]) : Character.toUpperCase(wordArray[i]);
                permute(String.valueOf(wordArray), i + 1, answer);
            }
        }
    }
}
