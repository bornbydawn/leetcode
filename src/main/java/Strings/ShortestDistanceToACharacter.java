package Strings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ShortestDistanceToACharacter {

    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        ShortestDistanceToACharacter object = new ShortestDistanceToACharacter();
        System.out.println(Arrays.toString(object.shortestToChar(s,c)));
    }

    public int[] shortestToChar(String s, char c) {
        List<Integer> charTracker = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c) charTracker.add(i);
        }
        int[] answer = new int[s.length()];

        for(int i = 0; i < s.length(); i++){
            int minDistance = Integer.MAX_VALUE;
            for(int j = 0; j < charTracker.size(); j++){
                if(Math.abs(charTracker.get(j) - i) < minDistance){
                    minDistance = Math.abs(charTracker.get(j) - i);
                    answer[i] = minDistance;
                }
                else{
                    break;
                }
            }
        }
        return answer;
    }
}
