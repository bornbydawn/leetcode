package WarmupContest;

import java.util.Arrays;

public class FirstNonRepeatingCharacter {

    public static int firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        int[] count = new int[26];

        Arrays.fill(count, 0);

        for(int i = 0; i < arr.length; i++){
            count[arr[i] - 97]++;
        }
        int answer = -1;

        for(int i = 0; i < arr.length; i++){
            if(count[arr[i] - 97] == 1){
                answer = i;
                break;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }
}
