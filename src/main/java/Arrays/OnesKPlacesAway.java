package Arrays;

public class OnesKPlacesAway {
    public static void main(String[] args) {
        OnesKPlacesAway object = new OnesKPlacesAway();
        int[] arr = new int[]{1,0,0,1,0,1};
        System.out.println(object.kLengthApart(arr, 2));
    }

    public boolean kLengthApart(int[] nums, int k) {

        if(nums.length == 1) return true;

        int last = -1;

        for(int i = 0; i < nums.length; i++){
                if(nums[i] == 1){
                    if(last == -1){
                        last = i;
                    }
                    else{
                        if(i - last <= k){
                            return false;
                        }
                        else{
                            last = i;
                        }
                    }
                }
        }
        return true;
    }
}
