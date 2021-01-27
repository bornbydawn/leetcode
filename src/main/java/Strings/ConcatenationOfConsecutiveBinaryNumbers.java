package Strings;

import java.math.BigInteger;

public class ConcatenationOfConsecutiveBinaryNumbers {
    public static void main(String[] args) {
        ConcatenationOfConsecutiveBinaryNumbers object = new ConcatenationOfConsecutiveBinaryNumbers();
        int n = 72387;
        //int n = 3;
        System.out.println(object.concatenatedBinary(n));
    }

    public int concatenatedBinary(int n) {

        long answer = 0;
        boolean[] number = new boolean[32];

        for(int i = 1 ; i <= n ; i++){
            int x = i;
            int index = 0;
            while(x != 0){
                number[index] = x%2 == 0 ? false : true;
                x /= 2;
                index++;
            }
            for(int j = index - 1; j >=0 ; j--){
                answer = (answer*2 + (number[j] ? 1 : 0))%1000000007;
            }
        }
        return (int) answer;
    }

//    public int concatenatedBinary(int n) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 1; i <= n; i++) {
//            stringBuilder.append(Integer.toBinaryString(i));
//        }
//        BigInteger midAnswer = new BigInteger(stringBuilder.toString(), 2);
//        midAnswer = midAnswer.mod(new BigInteger(Integer.toString(1000000007)));
//        return midAnswer.intValue();
//    }
}
