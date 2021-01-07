package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters object = new LongestSubstringWithoutRepeatingCharacters();
        //String s = "abcabcbb";
        //String s = "bbbbb";
        String s = "pwwkew";
        //String s = "au";
        //String s = "wobgrovw";
        System.out.println(object.lengthOfLongestSubstring(s));
    }

    //we dont need to remove values from hashmap before the new start since start will always be max of the duplicates index + 1 or start
    //since we have already moved start to right of all existing characters , max will always be start
    //for eg
    // a b c d e a e f g b
    //now start will be at e after duplicate a
    //now when b at end comes again , start is already at a later index than the existing b which is at index = 1
    //basically all values even if repeated after the last repeated values remain they dont affect since start is already ahead of them
    //and math.max will make sure we dont get affected by a previous repeating value
//    public int lengthOfLongestSubstring(String s) {
//
//        if (s.length() <= 1) return s.length();
//
//        char[] arr = s.toCharArray();
//        int start = 0;
//        int end = 1;
//        int maxLength = 1;
//        Map<Character, Integer> map = new HashMap<>();
//        map.put(arr[start], 0);
//        while (end < s.length()) {
//            if (map.containsKey(arr[end])) {
//                int k = map.get(arr[end]);
//                start = k + 1;
//
//                Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
//                while (it.hasNext()) {
//                    Map.Entry<Character, Integer> entrySet = it.next();
//                    if (entrySet.getValue() < start) {
//                        it.remove();
//                    }
//                }
//            }
//            map.put(arr[end], end);
//            maxLength = Math.max(maxLength, end - start + 1);
//            end++;
//        }
//        return maxLength;
//
//    }

    public int lengthOfLongestSubstring(String s) {

        if (s.length() <= 1) return s.length();

        int start = 0;
        int end = 1;
        int maxLength = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(start), 0);
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}
