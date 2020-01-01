public class LongestPalindromicSubsequence {

    static int getLongestCommonSubsequence(char[] s1, char[] s2) {

        int m = s1.length;
        int n = s2.length;
        int[][] dp = new int[s1.length + 1][s2.length + 1];

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

    public static void main(String[] args) {
        String s1 = "cbbd";
        String s2 = new StringBuilder().append(s1).reverse().toString();

        System.out.println(getLongestCommonSubsequence(s1.toCharArray(), s2.toCharArray()));
    }

}
