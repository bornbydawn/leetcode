package DynamicProgramming;

public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("2206"));
    }
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        if(s.length() == 1) return 1;


        int prevSolution = 1;
        int prevToPrevSolution = 1;

        for(int i = 1; i < s.length(); i ++){
            int current = s.charAt(i) - '0';
            int currentWithLast = (s.charAt(i-1) - '0')*10 + current;

            int currentCount = 0;
            if(current > 0) currentCount += prevSolution;
            if(currentWithLast >= 10 && currentWithLast <= 26) currentCount += prevToPrevSolution;
            prevToPrevSolution = prevSolution;
            prevSolution = currentCount;
        }

        return prevSolution;
    }
}
