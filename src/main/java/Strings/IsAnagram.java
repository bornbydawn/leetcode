package Strings;

import java.util.Arrays;

public class IsAnagram {

    public static void main(String[] args) {
        String s = "a", t = "b";
        System.out.println(new IsAnagram().isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if(s.isEmpty() && t.isEmpty()) return true;
        if(s.isEmpty() || t.isEmpty()) return false;

        int count[] = new int[26];

        Arrays.fill(count, 0);

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++){
            count[t.charAt(i) - 'a']--;
            if(count[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }

        for(int i = 0; i < count.length; i++){
            if(count[i] != 0) return false;
        }

        return true;
    }
}
