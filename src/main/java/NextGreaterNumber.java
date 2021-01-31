import java.util.Arrays;

public class NextGreaterNumber {

    public static void main(String[] args) {
        NextGreaterNumber nextGreaterNumber = new NextGreaterNumber();
        int n = 1999999999;
        System.out.println(nextGreaterNumber.nextGreaterElement(n));
    }

    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int nextGreaterElement(int n) {
        
        char[] number = Integer.toString(n).toCharArray();
    

        int firstMaxToMin = -1;
        for(int i = number.length - 1; i > 0; i--){
            if(number[i] > number[i - 1]){
                firstMaxToMin = i;
                break;
            }
        }

        if(firstMaxToMin == -1) return -1;

        int x = number[firstMaxToMin - 1];
        int indexWithMinGreaterElement = firstMaxToMin;

        for(int i = firstMaxToMin + 1; i < number.length; i++){
            if(number[i] > x && number[i] < number[indexWithMinGreaterElement]){
                indexWithMinGreaterElement = i;
            }
        }

        swap(number, firstMaxToMin - 1, indexWithMinGreaterElement);
        Arrays.sort(number, firstMaxToMin, number.length);

        try{
            return Integer.parseInt(new String(number));
        }
        catch(NumberFormatException nfe){
            return -1;
        }
      
    }
}
