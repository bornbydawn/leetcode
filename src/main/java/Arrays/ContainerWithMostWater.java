package Arrays;

public class ContainerWithMostWater {
    
    public static void main(String[] args) {
        int arr[] = new int[]{4,3,2,1,4};
        //int arr[] = new int[]{1,1};
        //int arr[] = new int[]{1,2,1};
        System.out.println(new ContainerWithMostWater().maxArea(arr));
    }
    // public int maxArea(int[] height) {
    //     int answer = 0;

    //     for(int i = 0; i < height.length - 1; i++){
    //         for(int j = height.length - 1; j > i; j--){
    //             answer = Math.max(answer, Math.min(height[i], height[j]) * (j - i));
    //         }
    //     }
    //     return answer;
    // }

    public int maxArea(int[] height) {
        int answer = 0;
        int l = 0, r = height.length - 1;
        while(l < r){
            answer = Math.max(answer, Math.min(height[l], height[r]) * (r - l));
            if(height[l] < height[r]) l ++;
            else r--;
        }
        return answer;
    }
}
