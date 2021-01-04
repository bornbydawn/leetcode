public class ReachANumber {
    public static void main(String[] args) {
        ReachANumber reachANumber = new ReachANumber();
        int target = 1;
        System.out.println(reachANumber.reachNumber(target));
    }

    public int reachNumber(int target) {
        return utilReachNumber(Math.abs(target), 0, 0);
    }

    private int utilReachNumber(int target, int moves, int i) {
       if(i == target) return moves;

       if(Math.abs(i) > target) return Integer.MAX_VALUE;

       moves++;

        return Math.min(utilReachNumber(target,moves, i - moves), utilReachNumber(target,moves, i + moves));
    }
}
