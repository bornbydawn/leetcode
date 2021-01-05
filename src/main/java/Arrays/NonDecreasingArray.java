package Arrays;

public class NonDecreasingArray {

    public static void main(String[] args) {
        //int[] nums = new int[]{5, 7, 1, 8};

        //int[] nums = new int[]{4,2,3};

        //int[] nums = new int[]{4,2,1};

        //int[] nums = new int[]{1,3,2};

        int[] nums = new int[]{-1, 4, 2, 3};

        //int[] nums = new int[]{3,4,2,3};

        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        System.out.println(nonDecreasingArray.checkPossibility(nums));
    }

    public boolean checkPossibility(int[] nums) {

        int count = 0;
        if (nums.length <= 2) return true;
        for (int i = 1; i < nums.length - 1; i++) {

            if(nums[i - 1] <= nums[i] && nums[i] <= nums [i + 1]) continue;
            //else if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1] && i == (nums.length - 2)) return false;
            else{
                if(nums[i] > nums[i + 1]) {
                    if(nums[i + 1] < nums[i - 1]){
                        nums[i + 1] = nums[i];
                    }
                    else{
                        nums[i] = nums[i + 1];
                    }
                    count++;
                }
                if(nums[i] < nums[i - 1]){
                    if(nums[i + 1] < nums[i - 1]){
                        nums[i - 1] = nums[i];
                    }
                    count++;
                }
            }
            if(count > 1) return false;
        }
        return true;
    }

}
