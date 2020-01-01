public class IsIntegerPalindrome {
    public static boolean isPalindrome(int x) {
        char[] arr = Integer.toString(x).toCharArray();
        int i = 0;
        int j = arr.length - 1;
        boolean answer = true;
        while(i < j){
            if(arr[j] != arr[i]){
                answer = false;
                break;
            }
            i++;
            j--;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(102));
    }
}
