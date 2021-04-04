package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        
        Map<Character, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());

        char[] answer = new char[s.length()];
        Arrays.fill(answer,' ');

        for(int i = 0; i < s.length(); i++){
            List<Integer> list = map.getOrDefault(s.charAt(i), new ArrayList<>());
            list.add(i);
            map.put(s.charAt(i), list);
        }

        for(List<Integer> list : map.values()){
            Collections.sort(list);
        }

        int minIndex = Integer.MAX_VALUE;
        for(Entry<Character, List<Integer>> entry : map.entrySet()){
            char c = entry.getKey();
            if(minIndex == Integer.MAX_VALUE){
                minIndex = entry.getValue().get(entry.getValue().size() - 1);
                answer[minIndex] = c;
            }
            else{
                boolean entered = false;
                for(int i = entry.getValue().size() - 1; i >= 0; i--){
                    if(entry.getValue().get(i) < minIndex){
                        entered = true;
                        minIndex = entry.getValue().get(i);
                        break;
                    }
                }
                if(!entered){
                    answer[entry.getValue().get(entry.getValue().size() - 1)] = c;
                }
                else{
                    answer[minIndex] = c;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.length; i++){
            if(answer[i] != ' '){
                sb.append(answer[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //String s = "bcabc";
        String s ="cbacdcbc";
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters(s));
    }
}
