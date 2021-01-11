package Arrays;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        MergeTwoSortedArrays object = new MergeTwoSortedArrays();
        object.merge(nums1, m, nums2, n);
        Arrays.stream(nums1).forEach(i -> System.out.print(i + ", "));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(n == 0) return;

        if(m == 0 && n == 0) return;

        if(m == 0){
            for(int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }

        int[] nums1Copy = Arrays.copyOf(nums1, m);
        int i = 0;
        int j = 0;
        int index = 0;
        while(i < m && j < n){
            if(nums1Copy[i] <= nums2[j]){
                nums1[index++] = nums1Copy[i++];

            }
            else{
                nums1[index++] = nums2[j++];
            }
        }

        while(i < m){
            nums1[index++] = nums1Copy[i++];
        }
        while(j < n){
            nums1[index++] = nums2[j++];
        }
    }


}
