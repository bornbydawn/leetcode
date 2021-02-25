package Strings;

import java.util.HashMap;
import java.util.Map;

public class StringToInteger {

    public static void main(String[] args) {

        //System.out.println(new StringToInteger().romanToInt("MCMXCIV"));
        //System.out.println(new StringToInteger().romanToInt("LVIII"));
        //System.out.println(new StringToInteger().romanToInt("IX"));
        //System.out.println(new StringToInteger().romanToInt("IV"));
        System.out.println(new StringToInteger().romanToInt("III"));
    }

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>(15);

        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);


        int start = s.length() - 1;
        int end = s.length() - 1;
        int answer = 0;
        while (end >= 0) {
            if (end - 1 >= 0 && map.containsKey(s.substring(end - 1, start + 1))) {
                end--;

            } else {
                if(end == 0){
                    answer += map.get(s.substring(end, start + 1));
                    return answer;
                }
                answer += map.get(s.substring(end, start + 1));
                start = end - 1;
            }
        }
        return answer;
    }
}
