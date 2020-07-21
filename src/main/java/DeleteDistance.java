public class DeleteDistance {
     private int getLongestCommonSubsequence(char[] s1, char[] s2, int m, int n, int dp[][]) {

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0 || j == 0)
                    dp[i][j] = 0;

                else if (s1[i - 1] == s2[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

            }
        }
        return dp[m][n];
    }
    public int minDistance(String word1, String word2) {



        if(word1.isEmpty() && word2.isEmpty()) return 0;
        if(word1.isEmpty()) return word2.length();
        if(word2.isEmpty()) return word1.length();
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 0; i < word1.length(); i++){
            dp[i][0] = 0;
        }

        for(int j = 0; j < word2.length(); j++){
            dp[0][j] = 0;
        }
        int maxCommonLength = getLongestCommonSubsequence(arr1, arr2, word1.length(), word2.length(), dp);
        return Math.abs(maxCommonLength - word1.length()) + Math.abs(maxCommonLength - word2.length());
    }

    public static void main(String[] args) {
        DeleteDistance o = new DeleteDistance();
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(o.minDistance(word1, word2));
    }

}
