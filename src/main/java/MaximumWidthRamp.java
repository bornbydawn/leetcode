import java.util.Arrays;

//https://leetcode.com/problems/maximum-width-ramp/
public class MaximumWidthRamp {

//    public int maxWidthRamp(int[] A) {
////        int maxWidth = 0;
////        for (int i = 0; i < A.length - 1; i++) {
////            for (int j = i + 1; j < A.length; j++) {
////                if((j - i) <= maxWidth) continue;
////                if ((A[i] <= A[j]) && (j - i) > maxWidth) {
////                    maxWidth = j - i;
////                }
////            }
////            if(A.length - i < maxWidth){
////                break;
////            }
////        }
////        return maxWidth;
////    }

    public int maxWidthRamp(int[] A) {
        if(A.length == 0){
            return 0;
        }
        int[] maxR = new int[A.length];
        maxR[A.length-1] = A[A.length-1];

        //why this max array serves the purpose is as follows:
        //if we have height as 2,3,5 at the ending indices
        //then choosing 5 for all three indices makes sense since 2 and 3 are at lower indices
        //and any left index height wanting to combine with the right index would always be
        //better off with the maximum of all three i.e. 5
        //since if some left indice is greater than 2 or 3 then it will definitely be greater
        //than 5 and hence j - i would be maximized by choosing 5. This means we can have
        //5 in place of 2 and 3 in the max array since 2 and 3 wont even matter at this point

        //we can have a min array also based on the same logic since we want the minimum
        //height so that it will give us the best possible chances of getting A[i] <= A[j]
        for(int i=A.length-2;i>=0;i--){
            maxR[i] = Math.max(A[i], maxR[i+1]);
        }
        System.out.println(Arrays.toString(maxR));

        int i=0;
        int j=0;
        int res = 0;
        while(i<A.length && j<A.length){
            if(A[i]<=maxR[j]){
                res = Math.max(res, j-i);
                j++;
            }else{
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] A = new int[]{9,8,1,0,1,9,4,0,4,1};
        MaximumWidthRamp maximumWidthRamp = new MaximumWidthRamp();
        System.out.println(maximumWidthRamp.maxWidthRamp(A));
    }
}
