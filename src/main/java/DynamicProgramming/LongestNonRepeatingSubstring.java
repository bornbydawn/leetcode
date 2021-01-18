package DynamicProgramming;

import java.util.HashMap;

public class LongestNonRepeatingSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if(s.equals(""))
            return 0;

        if(s.equals(" "))
            return 1;

        char[] characterArray = s.toCharArray();
        HashMap<Character, Integer> characterMap = new HashMap<>();
        int i = 0; int j = 0;
        int maxLength = 1;
        int length = 1;
        characterMap.put(characterArray[i], i);
        while(j < characterArray.length - 1 && j >= i){
            j++;
            if(characterMap.containsKey(characterArray[j])){
                i = characterMap.get(characterArray[j]) + 1;
                for(int k = 0; k < i; k++){
                    if(characterMap.containsKey(characterArray[k]) && characterMap.get(characterArray[k]) < i){
                        characterMap.remove(characterArray[k]);
                    }
                }
            }
            characterMap.put(characterArray[j], j);
            length = j - i + 1;
            if(length > maxLength) maxLength = length;
        }
        return maxLength;
    }


    public static void main(String[] args) {

        String string = "dvdvdf";
        System.out.println(lengthOfLongestSubstring(string));
    }
}
