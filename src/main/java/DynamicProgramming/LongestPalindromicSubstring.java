package DynamicProgramming;

public class LongestPalindromicSubstring {


    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        int n = s.length();
        int maxLength = 1;
        boolean matrix[][] = new boolean[n][n];
        //all substrings of length 1 are palindromes
        for(int i = 0; i < n; i++){
            matrix[i][i] = true;
        }

        // all length 2 with same chars
        int start = 0;
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                matrix[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }


        //k is substr length that is why =n also
        for( int k = 3; k <= n ; k ++){

            for(int i = 0; i < n-k+1; i ++){
                int j = i + k - 1;

                if(matrix[i + 1][j - 1] && s.charAt(i) == s.charAt(j)){
                    matrix[i][j] = true;
                    if(k > maxLength){
                        maxLength = k;
                        start = i;
                    }
                }
            }
        }

        int end = start + maxLength - 1;
        StringBuilder s1 = new StringBuilder();
        for(int i = start; i <= end; i++){
            s1.append(s.charAt(i));
        }
        return s1.toString();

    }

    public static void main(String[] args) {
//        String s1 = "abcda";
//        String s2 = "adcba";

        String s1 = "ac";
        //String s2 = "bcd";

        LongestPalindromicSubstring object = new LongestPalindromicSubstring();
        System.out.println(object.longestPalindrome(s1));
    }
}
