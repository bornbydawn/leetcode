import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings obj = new MultiplyStrings();
        String num1 = "123";
        String num2 = "456";
        System.out.println(obj.multiply(num1, num2));
    }

    public String multiply(String num1, String num2) {

        String str;
        char[] numOne = num1.toCharArray();
        char[] numTwo = num2.toCharArray();
        StringBuilder result = new StringBuilder();

        LinkedList<String> toSum = new LinkedList<>();

        int smallerLength;
        int biggerLength;
        char[] smallerNumber;
        char[] biggerNumber;

        if (num2.length() <= num1.length()) {
            smallerLength = num2.length();
            smallerNumber = numTwo;

            biggerLength = num1.length();
            biggerNumber = numOne;
        } else {
            smallerLength = num1.length();
            smallerNumber = numOne;

            biggerLength = num2.length();
            biggerNumber = numTwo;
        }
        int product = 0;
        int carry = 0;
        int zeroCounter = 0;

        for (int i = smallerLength - 1; i >= 0; i--) {
            StringBuilder number = new StringBuilder();
            carry = 0;
            product = 0;
            for (int j = biggerLength - 1; j >= 0; j--) {

                product = (biggerNumber[j] - 48) * (smallerNumber[i] - 48);
                product = product + carry;
                carry = product / 10;
                number.append(product % 10);
            }
            if(carry > 0){
                number.append(carry);
            }
            number.reverse();

            for (int k = 0; k < zeroCounter; k++) {
                number.append(0);
            }
            toSum.add(number.toString());
            zeroCounter++;
        }
        List<char[]> listOfNumbers = new ArrayList<>(toSum.size());
        int longestStringLength = 0;

        for(String s : toSum){
            if(longestStringLength < s.length()){
                longestStringLength = s.length();
            }
            listOfNumbers.add(s.toCharArray());
        }
        StringBuilder answer = new StringBuilder();
        int sum = 0;
        carry = 0;
        for(int i = 0; i < longestStringLength; i++){

            sum = 0;
            sum = sum + carry;
            for(int j = 0; j < listOfNumbers.size(); j++){
                if(i + 1 <= listOfNumbers.get(j).length){
                    sum = sum + (listOfNumbers.get(j)[listOfNumbers.get(j).length - i - 1] - 48);
                }
            }
            answer.append(sum % 10);
            carry = sum /10;
        }
        if(carry > 0){
            answer.append(carry);
        }
        answer.reverse();


        if(answer.toString().chars().filter(ch -> ch == '0').count() == answer.length()){
            return "0";
        }
        else{
            return answer.toString();

        }

    }

}
