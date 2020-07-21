public class LongestCommonSubstring {

    private static String getLongestCommonSubstringLength(String s1, String s2){

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for(int i = 0; i < s1.length(); i++){
            dp[i][0] = 0;
        }

        for(int j = 0; j < s2.length(); j++){
            dp[0][j] = 0;
        }

        int maxLength = 0;
        int endIndex = 0;

        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++){
                if(i == 0 || j == 0) continue;


                if(arr1[i - 1] != arr2[j - 1])
                    dp[i][j] = 0;
                else{
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if(dp[i][j] > maxLength){
                    maxLength = dp[i][j];
                    endIndex = j - 1;
                }
            }
        }

        int startIndex = endIndex - maxLength + 1;
        StringBuilder s = new StringBuilder();
        for(int i = startIndex; i <= endIndex; i++){
            s.append(arr2[i]);
        }

        return s.toString();
    }

    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";

        System.out.println(getLongestCommonSubstringLength(s1, s2));
    }
}
