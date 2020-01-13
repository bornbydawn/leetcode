// https://leetcode.com/problems/search-a-2d-matrix-ii/submissions/

public class SearchA2dMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0) return false;
        int i = 0;
        int j;
        int verticalLength = matrix.length;
        int horizontalLength = matrix[0].length;

        while(i < Math.min(verticalLength, horizontalLength) && matrix[i][i] <= target && i < verticalLength){

            if(matrix[i][i] == target) return true;

            if(matrix[i][horizontalLength - 1] >= target){
                j = i;
                while(j < horizontalLength - 1){
                    j++;
                    if(matrix[i][j] == target) return true;
                }
            }

            if(matrix[verticalLength - 1][i] >= target){
                j = i;
                while(j < verticalLength - 1){
                    j++;
                    if(matrix[j][i] == target) return true;
                }
            }

            i++;
        }

        return false;
    }

    public static void main(String[] args) {
//        int[][] foo = new int[][] {
//                new int[] { 1,   4,  7, 11, 15},
//                new int[] { 2,   5,  8, 12, 19},
//                new int[] { 3,   6,  9, 16, 22},
//                new int[] { 10, 13, 14, 17, 24},
//                new int[] { 18, 21, 23, 26, 30},
//        };
 int[][] foo = new int[][] {

        };

        SearchA2dMatrix2 searchA2dMatrix2 = new SearchA2dMatrix2();
        System.out.println(searchA2dMatrix2.searchMatrix(foo, 121));
    }
}
