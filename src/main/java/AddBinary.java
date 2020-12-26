public class AddBinary {

    public static void main(String[] args) {
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

        addBinary(a, b);
    }
    public static String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        String num1 = String.format("%10000s",a);
        num1 = num1.replace(' ','0');

        String num2 = String.format("%10000s",b);
        num2 = num2.replace(' ','0');

        num1 = stringBuilder.append(num1).reverse().toString();
        stringBuilder.setLength(0);

        num2 = stringBuilder.append(num2).reverse().toString();


        char[] number1 = num1.toCharArray();
        char[] number2 = num2.toCharArray();

        stringBuilder.setLength(0);

        for(int i = 0; i < 10000; i++){
            if(number1[i] == 0 && number2[i] == 0){

            }
        }
//
//        System.out.println(num1[0] + " " + num1[1]);

        return "";
    }
}
