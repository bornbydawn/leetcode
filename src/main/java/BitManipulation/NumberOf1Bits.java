package BitManipulation;

public class NumberOf1Bits {



    public static void main(String[] args) {
        int n = 1110000100;
        NumberOf1Bits numberOf1Bits = new NumberOf1Bits();
        System.out.println(numberOf1Bits.hammingWeight(n));
    }

    //number 0 has 0 set 1 bits
    //number 1 has 1 set 1 bits
    //number 2 has 2 set 1 bits
    static int[] num_to_bits = new int[] { 0, 1, 1, 2, 1, 2, 2,
            3, 1, 2, 2, 3, 2, 3, 3, 4 };
    public int hammingWeight(int n) {
        int answer = 0;

        while (n >= 0){
            answer += num_to_bits[n & 0xf];
            n = n>>>4;
        }
        return answer;
    }

}
