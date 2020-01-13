import java.util.Arrays;

// https://leetcode.com/problems/uncrossed-lines/submissions/
public class MaxUncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {

        int dp[][] = new int[A.length + 1][B.length + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return maxUncrossedLines(A, B, 0, 0, dp);
    }

    private int maxUncrossedLines(int[] A, int[] B, int i, int j, int[][] dp) {

        if (i == A.length || j == B.length) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if (A[i] == B[j]) {
            return dp[i][j] = Math.max(1 + maxUncrossedLines(A, B, i + 1, j + 1, dp), maxUncrossedLines(A, B, i + 1, j, dp));
        } else {
            return dp[i][j] = Math.max(Math.max(maxUncrossedLines(A, B, i + 1, j, dp), maxUncrossedLines(A, B, i, j + 1, dp)), maxUncrossedLines(A, B, i + 1, j + 1, dp));
        }
    }

    public static void main(String[] args) {
        MaxUncrossedLines maxUncrossedLines = new MaxUncrossedLines();

        int[] A = new int[]{1,1,3,5,3,3,5,5,1,1};
        int[] B = new int[]{2,3,2,1,3,5,3,2,2,1};

        System.out.println(maxUncrossedLines.maxUncrossedLines(A, B));
    }
}
