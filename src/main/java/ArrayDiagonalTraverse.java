public class ArrayDiagonalTraverse {

    public static void main(String[] args) {

        int[][] arr = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};

        ArrayDiagonalTraverse arrayDiagonalTraverse = new ArrayDiagonalTraverse();
        System.out.println(arrayDiagonalTraverse.findDiagonalOrder(arr));
    }

    public int[] findDiagonalOrder(int[][] matrix) {

        int rows = matrix.length;

        int columns = matrix[0].length;
        int [] result = new int[rows * columns];

        int xMax = rows - 1;
        int yMax = columns - 1;
        int x = 0; int y = 0;
        int i = 0;
        result[i++] = matrix[0][0];
        if(columns > 1){
            y++;
        }
        else if(rows > 1){
            x++;
        }
        else{
            return result;
        }
        while(x <= xMax && y <= yMax){
            while(y != 0 || x != xMax){
                if(y < 0){
                    y = 0;
                    break;
                }
                if(x > xMax){
                    x = xMax;
                    //y =
                    break;
                }
                result[i++] = matrix[x][y];
                x++; y--;

            }
            while(x != 0 || y != yMax){
                if(x < 0){
                    x = 0;
                    break;
                }
                result[i++] = matrix[x][y];
                x--; y++;
            }
        }

        return result;

    }
}
