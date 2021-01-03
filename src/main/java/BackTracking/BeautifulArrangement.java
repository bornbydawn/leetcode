package BackTracking;

public class BeautifulArrangement {

    class NumWrapper{
        int count;
        public NumWrapper(){
            count = 0;
        }
    }

    public static void main(String[] args) {
        int n = 15;
        BeautifulArrangement beautifulArrangement = new BeautifulArrangement();
        System.out.println(beautifulArrangement.countArrangement(n));
    }


    public int countArrangement(int n) {

        int []arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = i;
        }

        NumWrapper numWrapper = new NumWrapper();
        permute(arr, 1, n, numWrapper);

        return numWrapper.count;
    }

    private void permute(int arr[], int l, int r, NumWrapper numWrapper){
        if(l == r){
         if(checkIfValid(arr)){
             numWrapper.count++;
         }
         return;
        }
        else
        {
            for (int i = l; i <= r; i++)
            {
                swap(arr,l,i);
                if((arr[l] % l) == 0 || (l % arr[l]) == 0){
                    permute(arr, l+1, r, numWrapper);
                }
                swap(arr,l,i);
            }
        }
    }

    private void swap(int []arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean checkIfValid(int arr[]){

        for(int i = 1 ; i < arr.length; i++){
            if((arr[i] % i) != 0 && (i % arr[i]) != 0){
                return false;
            }
        }
        return true;
    }
}
