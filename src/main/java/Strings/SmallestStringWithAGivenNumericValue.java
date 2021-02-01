package Strings;

public class SmallestStringWithAGivenNumericValue {
    public static void main(String[] args) {

        SmallestStringWithAGivenNumericValue object = new SmallestStringWithAGivenNumericValue();
        int n = 2;
        int k = 26;
        System.out.println(object.getSmallestString(n, k));
    }

    public String getSmallestString(int n, int k) {
        char[] string = new char[n];
        k = k - n;
        for(int i = n - 1; i >=0 ; i--){
            int asciiToAdd =  Math.min(25, k);
            if(asciiToAdd <= 0){
                string[i] = 'a';
            }
            else{
                string[i] = (char)(97 + asciiToAdd);
            }
            k = k - asciiToAdd;
        }
        return String.copyValueOf(string);
    }
}
