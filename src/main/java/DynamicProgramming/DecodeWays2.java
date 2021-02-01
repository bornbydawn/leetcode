package DynamicProgramming;

public class DecodeWays2 {

    public static void main(String[] args) {
        DecodeWays2 decodeWays = new DecodeWays2();
        //System.out.println(decodeWays.numDecodings("1***"));

        //System.out.println(decodeWays.numDecodings("1**"));
        //177
        //System.out.println(decodeWays.numDecodings("1**7"));
        System.out.println(decodeWays.numDecodings("********"));
        //System.out.println(decodeWays.numDecodings("*2*1*34*5*10"));
        //System.out.println(decodeWays.numDecodings("*2*1"));
        //326898

    }
    public int numDecodings(String s) {
        int mod = 1000000007;
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        if(s.length() == 1){
            return s.charAt(0) == '*' ? 9 : 1;
        }

        int prevSolution = s.charAt(0) == '*' ? 9 : 1;
        int prevToPrevSolution = 1;

        for(int i = 1; i < s.length(); i ++){

            if(s.charAt(i) == '*'){
                int currentCount = prevSolution * 9;
                if(s.charAt(i - 1) == '*'){
                    //currentCount = currentCount + 17 + prevSolution;
                    currentCount = (currentCount + prevToPrevSolution*15)%mod;
                }
                else{
                    int last = s.charAt(i-1) - '0';
                    if(last != 0){
                        if(last == 1) currentCount = (currentCount + prevToPrevSolution*9)%mod;
                        else if(last == 2) currentCount = (currentCount + prevToPrevSolution*6)%mod;
                    }
                }
                prevToPrevSolution = prevSolution;
                prevSolution = currentCount;
            }

            else{
                int current = s.charAt(i) - '0';
                int currentCount = 0;
                if(current > 0) currentCount = (currentCount + prevSolution)%mod;

                int currentWithLast;
                if(s.charAt(i - 1) != '*'){
                    currentWithLast = (s.charAt(i-1) - '0')*10 + current;
                    if(currentWithLast >= 10 && currentWithLast <= 26) currentCount = (currentCount + prevToPrevSolution)%mod;
                }
                else{
                    if(current >= 0 & current <=6){
                        currentCount = (currentCount + prevToPrevSolution*2)%mod;
                    }
                    else{
                        currentCount = (currentCount + prevToPrevSolution)%mod;
                    }
                }

                prevToPrevSolution = prevSolution;
                prevSolution = currentCount;
            }

        }

        return prevSolution;
    }
}
