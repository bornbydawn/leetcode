public class ThousandsSeperator {
    public String thousandSeparator(int n) {
        if (n <= 999)
            return Integer.toString(n);
        else {
            StringBuilder sb = new StringBuilder();
            short commaDecider = 0;
            while (n != 0) {
                if (commaDecider == 3) {
                    sb.append(",");
                    commaDecider = 0;
                }
                sb.append(n % 10);
                n /= 10;
                commaDecider++;
            }
            return sb.reverse().toString();
        }
    }

    public static void main(String[] args) {
            int n = 1023094781;
            System.out.println(new ThousandsSeperator().thousandSeparator(n));
    }
}
