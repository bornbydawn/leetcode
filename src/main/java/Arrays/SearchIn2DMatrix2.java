package Arrays;

public class SearchIn2DMatrix2 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 10;
        System.out.println(new SearchIn2DMatrix2().searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int columns = matrix[0].length - 1;

        int m = 0;
        int n1 = columns;
        while (m < rows && n1 >= 0) {
            if (matrix[m][n1] == target) return true;
            if (matrix[m][n1] > target) {
                n1--;
            } else {
                m++;
            }
        }
        return false;
    }
}
