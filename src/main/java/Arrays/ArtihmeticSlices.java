package Arrays;

public class ArtihmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) return 0;
        int slices = 0;


        //slices starting from i
        for(int i = 0;  i < A.length - 2; i++){

            int start = i;
            int current = i + 1;
            
            int diff = A[current] - A[start];
            
            while(current != A.length){
                if (!(A[current] - A[current - 1] == diff)){
                    break;
                }
                if(current - start >= 2) slices++;
               current++;
            }
        }

        return slices;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 100, 2, 3, 4, 5};
        //int arr[] = new int[]{1, 2, 3, 4, 100, 2, 3, 4};
        //int arr[] = new int[]{1, 2, 3, 4};
        System.out.println(new ArtihmeticSlices().numberOfArithmeticSlices(arr));
    }
}
