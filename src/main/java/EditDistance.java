//https://leetcode.com/problems/edit-distance/
//https://www.techiedelight.com/levenshtein-distance-edit-distance-problem/
import java.util.Arrays;
public class EditDistance {
    public int minDistance(String word1, String word2) {

        if(word1.length() == 0 && word2.length() == 0) return 0;
        char a[] = word1.toCharArray();
        char b[] = word2.toCharArray();
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        Arrays.stream(dp).forEach(i -> Arrays.fill(i, -1));
        //return getMinCost(word1.length() -1, word2.length() -1, a,b, dp);
        return getMinCostBottomUp(a,b, dp);
    }

    //complexity O(mn) space and O(3 power n) time
    private int getMinCost(int i, int j, char a[], char b[], int dp[][]){

        if(i < 0 && j < 0) return 0;
        if(i < 0 && j >=0) return j+1;
        if(j < 0 && i >= 0) return i+1;

        if(dp[i][j] != -1) return dp[i][j];
        if(a[i] == b[j]) return dp[i][j] = getMinCost(i -1, j - 1, a,b, dp);

        return dp[i][j] = Math.min(Math.min(1 + getMinCost(i, j -1, a,b,dp), 1 + getMinCost(i -1, j- 1, a,b,dp)) , 1 + getMinCost(i - 1, j, a,b, dp));
    }


    //complexity O(mn) space and time
    private int getMinCostBottomUp(char[] a, char b[], int dp[][]){
        int m = a.length;
        int n = b.length;

        //if b is empty string drop all characters from a
        for(int i = 0; i <= m; i++){
            dp[i][0] = i;
        }

        // if a is empty string add all characters from b
        for(int j = 0; j <= n; j++){
            dp[0][j] = j;
        }


        int cost = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(a[i - 1] == b[j - 1]) cost = 0;
                else{
                    cost = 1;
                }
                dp[i][j] = Math.min((Math.min(dp[i - 1][j]  + 1,  //delete character from source string with one cost
                                    dp[i][j - 1] + 1)), //copy one character from target string at last position
                                        dp[i - 1][j - 1] + cost); // replace current character in source string from target string
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        EditDistance obj = new EditDistance();
        System.out.println(obj.minDistance(word1, word2));
    }
}
