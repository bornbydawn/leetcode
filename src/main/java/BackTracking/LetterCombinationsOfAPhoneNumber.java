package BackTracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {

        List<String> answers = new LinkedList<>();

        if(digits == null || digits.trim().isEmpty()){
            return answers;
        }

        Map<Character, char[]> characterMap = new HashMap<>();
        characterMap.put('0', new char[]{});
        characterMap.put('1', new char[]{});
        characterMap.put('2', new char[]{'a','b','c'});
        characterMap.put('3', new char[]{'d','e','f'});
        characterMap.put('4', new char[]{'g','h','i'});
        characterMap.put('5', new char[]{'j','k','l'});
        characterMap.put('6', new char[]{'m','n','o'});
        characterMap.put('7', new char[]{'p','q','r','s'});
        characterMap.put('8', new char[]{'t','u','v'});
        characterMap.put('9', new char[]{'w','x','y','z'});

        StringBuilder sb = new StringBuilder();

        char[] digitsArray = digits.toCharArray();

        doCombinations(digitsArray, sb, characterMap, answers);

        return answers;
    }

    private void doCombinations(char[] digits, StringBuilder stringBuilder, Map<Character, char[]> characterMap, List<String> answers){

        if(stringBuilder.length() == digits.length){
            answers.add(stringBuilder.toString());
            return;
        }

        for(char character : characterMap.get(digits[stringBuilder.length()])){
            stringBuilder.append(character);
            doCombinations(digits, stringBuilder, characterMap, answers);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }


    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber object = new LetterCombinationsOfAPhoneNumber();
        System.out.println(object.letterCombinations("78342"));
    }
}
