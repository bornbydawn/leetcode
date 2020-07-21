package BinarySearch;
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
import java.util.Arrays;

public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int D) {

        if(weights.length == 1) return weights[0];
        if(D == 1) return Arrays.stream(weights).sum();

        int end = Arrays.stream(weights).sum();
        int start = 1;
        int answer = 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(checkIfMinimumPossibleWeight(mid, D, weights)){
                answer = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return answer;
    }
    private boolean checkIfMinimumPossibleWeight(int mid, int D, int weight[]){
        int count = 0;
        int sum = 0;

        for(int i = 0; i < weight.length; i++){
            if(weight[i] > mid) return false;

            sum += weight[i];

            if(sum > mid){
                count++;
                //we start a new subarray from here by just taking this new weight since till before this weight we have filled one subarray
                // we will start a new subarray each time we exceed the weight (mid right now)
                sum = weight[i];
            }
        }
        //this is for the last subarray
        count++;

        if(count <= D) return true;
        return false;
    }

    public static void main(String[] args) {
        ShipWithinDays shipWithinDays = new ShipWithinDays();
        int weights[] = new int[]{1,2,3,1,1};
        int days = 4;
        System.out.println(shipWithinDays.shipWithinDays(weights, days));
    }
}
