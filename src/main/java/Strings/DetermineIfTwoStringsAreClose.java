package Strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//https://leetcode.com/problems/determine-if-two-strings-are-close/
public class DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {

        DetermineIfTwoStringsAreClose object = new DetermineIfTwoStringsAreClose();
        String word1 = "cabbba";
        String word2 = "abbccc";
        System.out.println(object.closeStrings(word1, word2));
        
    }

    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        Map<Character, Integer> charaterCountMap = new HashMap<>();
        Set<Character> characterSet = new HashSet<>();

        for(int i = 0; i < word1.length(); i++){
            characterSet.add(word1.charAt(i));
           if(charaterCountMap.containsKey(word1.charAt(i))){
               charaterCountMap.put(word1.charAt(i), charaterCountMap.get(word1.charAt(i)) + 1);
           }
           else{
               charaterCountMap.put(word1.charAt(i), 1);
           }
        }

        List<Integer> flistWord1;
        flistWord1 = charaterCountMap.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
        Collections.sort(flistWord1);
        //System.out.println(flistWord1.toString());

        List<Character> cList = characterSet.stream().map(s -> s.charValue()).collect(Collectors.toList());
        Collections.sort(cList);
        //System.out.println(cList.toString());

        charaterCountMap.clear();

        Set<Character> characterSet2 = new HashSet<>();

        for(int i = 0; i < word2.length(); i++){
            if(!characterSet.contains(word2.charAt(i))) return false;
            characterSet2.add(word2.charAt(i));
            if(charaterCountMap.containsKey(word2.charAt(i))){
                charaterCountMap.put(word2.charAt(i), charaterCountMap.get(word2.charAt(i)) + 1);
            }
            else{
                charaterCountMap.put(word2.charAt(i), 1);
            }
         }

         List<Integer> flistWord2;
         flistWord2 = charaterCountMap.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
         Collections.sort(flistWord2);
         
         //System.out.println(flistWord2.toString());
 
         List<Character> cList2 = characterSet2.stream().map(s -> s.charValue()).collect(Collectors.toList());
         Collections.sort(cList2);

         //System.out.println(cList2.toString());

         if(!flistWord1.equals(flistWord2)) return false;
         if(!cList.equals(cList2)) return false;

        return true;
    }
}
