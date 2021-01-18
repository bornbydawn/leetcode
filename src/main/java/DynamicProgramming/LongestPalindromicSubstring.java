package DynamicProgramming;

public class LongestPalindromicSubstring {


    private static String getLongestPalindromicSubstring(String s1){

        char[] arr1 = s1.toCharArray();
        int maxLength = 0;
        int iMax = 0;
        int jMax = 0;
        for(int i = 0; i < s1.length(); i++){
            for(int j = 1; j < s1.length(); j++){
               if(isPalindrome(arr1, i, j)){
                   if((j - i + 1) > maxLength){
                       maxLength = j - i + 1;
                       iMax = i;
                       jMax = j;
                   }
               }
            }
        }

        StringBuilder s = new StringBuilder();
        for(int i = iMax; i <= jMax; i++){
            s.append(arr1[i]);
        }
        return s.toString();

    }

    public static void main(String[] args) {
//        String s1 = "abcda";
//        String s2 = "adcba";

        String s1 = "babad";
        //String s2 = "bcd";

        System.out.println(getLongestPalindromicSubstring(s1));
    }

    private static boolean isPalindrome(char[] s1, int i,int j){
        while(i < j){
            if(s1[i] != s1[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
