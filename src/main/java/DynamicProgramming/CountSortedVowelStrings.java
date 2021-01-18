package DynamicProgramming;

import java.util.Arrays;
//https://www.youtube.com/watch?v=gdt7HQF56OI
public class CountSortedVowelStrings {

   
    public static void main(String[] args) {
        CountSortedVowelStrings countSortedVowelStrings = new CountSortedVowelStrings();
      
        int n = 3;
        System.out.println(countSortedVowelStrings.countVowelStrings(n));
    }

    // class NumWrapper {
    //     int count = 0;
    // }

    // public int countVowelStrings(int n) {
    
    //     NumWrapper numWrapper = new NumWrapper();

    //     Map<Character, List<Character>> possibleMap = new HashMap<>();
    //     //possibleMap.putIfAbsent(' ', Arrays.asList('a', 'e', 'i', 'o', 'u'));
    //     possibleMap.put('a', Arrays.asList('a','e', 'i', 'o', 'u'));
    //     possibleMap.put('e', Arrays.asList('e', 'i', 'o', 'u'));
    //     possibleMap.put('i', Arrays.asList('i', 'o', 'u'));
    //     possibleMap.put('o', Arrays.asList('o', 'u'));
    //     possibleMap.put('u', Arrays.asList('u'));

    //     countVowelStrings(n, 'a', possibleMap, numWrapper);

    //     return numWrapper.count;
        
    // }

    // private int countVowelStrings(int n, char lastCharacter, Map<Character,  List<Character>> possibleMap, NumWrapper numWrapper){
    //     if(n == 0) return 0;
        
    //     for(Character character : possibleMap.get(lastCharacter)){
    //         numWrapper.count += countVowelStrings(n - 1, character, possibleMap, numWrapper);
    //     }

    //     return possibleMap.get(lastCharacter).size();
    // }

    public int countVowelStrings(int n) {
    
        int arr[] = new int[]{1,1,1,1,1};

        for(int i = 2; i <=n ; i++){
            for(int j = 3; j >=0 ; j --){
                arr[j] += arr[j + 1];
            }
        }

        int answer = Arrays.stream(arr).sum();
        return answer;
        
    }
}
